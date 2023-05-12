package assignment2;

public class Region {

    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public Region(int minX, int minY, int maxX, int maxY){
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean contains(Position pos){
        boolean inX = false;
        boolean inY = false;

        if(pos.getX() >= minX && pos.getX() <= maxX){
            inX = true;
        }

        if(pos.getY() >= minY && pos.getY() <= maxY){
            inY = true;
        }

        //System.out.println(inX);
        //System.out.println(inY);

        return (inX && inY);
    }

}
