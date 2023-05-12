package assignment2;

public class World {

    private Caterpillar bug;
    private Position curPos;
    private Region map;
    private ActionQueue actions;
    private TargetQueue targets;
    private Position foodPos;
    private GameState state;
    private Direction dir;

    public World(TargetQueue targets, ActionQueue actions){
        this.targets = targets;
        this.actions = actions;
        this.map = new Region(0,0,15,15);
        this.bug = new Caterpillar();
        this.dir = Direction.NORTH;

        curPos = new Position(7,7);
        foodPos = targets.dequeue();
        state = GameState.MOVE;

    }

    public void step(){

        if(!actions.isEmpty()){
            dir = actions.dequeue();
        } else {
            state = GameState.NO_MORE_ACTION;
        }

        if(state != GameState.MOVE && state != GameState.EAT){
            return;
        }

        curPos = bug.getHead();
        Position nextPos = new Position(curPos.getX(), curPos.getY());

        if(dir == Direction.NORTH){
            nextPos.moveNorth();
        } else if (dir == Direction.SOUTH) {
            nextPos.moveSouth();
        } else if (dir == Direction.EAST) {
            nextPos.moveEast();
        } else if (dir == Direction.WEST) {
            nextPos.moveWest();
        }

        if(bug.selfCollision(nextPos)){
            state = GameState.SELF_COLLISION;
            return;
        }
        if(!map.contains(nextPos)){
            state = GameState.WALL_COLLISION;
            return;
        }
        if(nextPos.equals(foodPos)){
            state = GameState.EAT;
            bug.eat(foodPos);

            if(targets.isEmpty()){
                state = GameState.DONE;
            } else {
                foodPos = targets.dequeue();
            }
            return;
        }

        bug.move(nextPos);
        curPos = nextPos;
        state = GameState.MOVE;
    }

    public GameState getState(){
        return state;
    }

    public Caterpillar getCaterpillar(){
        return bug;
    }

    public Position getFood(){
        return foodPos;
    }

    public boolean isRunning(){
        return (state == GameState.MOVE || state == GameState.EAT);
    }

}
