package assignment2;

public class Caterpillar extends MyDoublyLinkedList<Position>{


    public Caterpillar(){
        Position start = new Position(7,7);
        addFirst(start);
        //System.out.println(getSize());
    }

    public Position getHead(){
        return peekFirst();
    }

    public void eat(Position foodPos){
        if(Position.getDistance(getHead(), foodPos) > 1){
            throw new IllegalArgumentException("too far");
        }
        /*
        if(foodPos.getY() != getHead().getY() + 1 || foodPos.getY() != getHead().getY() - 1){
            throw new IllegalArgumentException("y too far");
        }
         */

        addFirst(foodPos);
    }

    public void move(Position newPos){
        if(Position.getDistance(getHead(), newPos) > 1){
            throw new IllegalArgumentException("too far");
        }
        /*
        if(newPos.getY() != getHead().getY() + 1 || newPos.getY() != getHead().getY() - 1){
            throw new IllegalArgumentException("y too far");
        }
         */

        addFirst(newPos);
        removeLast();
    }

    public boolean selfCollision(Position pos){
        for(Position position : this){
            if(pos.equals(position)){
               return true;
            }
        }
        return false;
    }

}
