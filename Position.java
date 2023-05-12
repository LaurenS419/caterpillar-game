package assignment2;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position(Position pos){
        this.x = pos.x;
        this.y = pos.y;
    }

    public void reset(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void reset(Position pos){
        this.x = pos.x;
        this.y = pos.y;
    }

    static public int getDistance(Position pos1, Position pos2){
        int diffx = pos1.x - pos2.x;
        int diffy = pos1.y - pos2.y;

        if(diffx < 0){
            diffx = diffx * -1;
        }
        if(diffy < 0){
            diffy = diffy * -1;
        }

        return diffx + diffy;

    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void moveWest(){
        this.x = this.x - 1;
    }

    public void moveEast(){
        this.x = this.x + 1;
    }

    public void moveNorth(){
        this.y = this.y - 1;
    }

    public void moveSouth(){
        this.y = this.y + 1;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Position)){
            return false;
        }
        if(((Position) obj).getX() != this.x){
            return false;
        }
        if(((Position) obj).getY() != this.y){
            return false;
        }

        return true;
    }
}
