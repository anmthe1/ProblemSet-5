public class Point {
    private int x,y;

    //constructor to initialize x and y to 0
    public Point (){
        x = 0;
        y = 0;
    }
    // Assign int x and y as instance variables
    public Point (int x, int y){
        this.x = x;
        this.y = y;
    }
    //create mutators and accessors
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}