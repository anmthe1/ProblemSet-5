import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    //make snake elongate as points increases
    static List<Point> snakePoints;
    int xDir, yDir;
    //boolean phrases to detect snake movement and elongation, remember snake cannot move backwards
    boolean isMoving, elongate;
    //specify start location
    final int STARTSIZE = 20, STARTX = 150, STARTY = 150;

    public Snake() {
        snakePoints = new ArrayList<Point>();
        //integers of x and y direction:x -1 will be left +1 is right; y -1 goes up, +1 goes down; 0 is static
        xDir = 0;
        yDir = 0;
        isMoving = false;
        elongate = false;

        //create first points and create loop to create other points
        snakePoints.add(new Point(STARTX, STARTY));
        for (int i = 1; i < STARTSIZE; i++) { //subtract and push snake by 4 as it is made up by 4 x 4 rectangles
            snakePoints.add(new Point(STARTX - i * 4, STARTY));
        }
    }

    //take graphics g to create snake object in snake game; make snake white colored (rectangular shape)
    public void draw(Graphics g) {
        g.setColor(Color.white);
        for (Point p : snakePoints) { //snake is made up of many rectangles 4 by 4 (dependent on snake points), y is the same as it is the same horizontally until snake moves
            g.fillRect(p.getX(), p.getY(), 4, 4);
            System.out.println(p);
        }
    }

    // create accessors for xDir and yDir
    public int getXDir() {
        return xDir;
    }

    public int getYDir() {
        return yDir;
    }

    //create setters for xDir and yDir
    public void setXDir(int x) {
        xDir = x;
    }

    public void setyDir(int y) {
        yDir = y;
    }

    //position of snake head (front) will always be element 0 of array list
    public int getX() {
        return snakePoints.get(0).getX(); //gets the first elements and returns x
    }

    public int getY() {
        return snakePoints.get(0).getY(); ////gets the first elements and returns y
    }

    //snake elongation
    public void setElongate(boolean b){
        elongate = b;
    }


    // create method to make snake move (if true) by being called in infinite loop
    public void move() {
        if (isMoving) {
            Point temp = snakePoints.get(0); // records intial position at element 0
            Point last = snakePoints.get(snakePoints.size() - 1); // records snake end position (hence -1 (last rectangle)
            Point newStart = new Point(temp.getX() + xDir * 4, temp.getY() + yDir * 4);
            //create loop that creates snake point backwards (using the point in front as initial)
            for (int i = snakePoints.size() - 1; i >= 1; i--) {
                snakePoints.set(i, snakePoints.get(i - 1));// updates entire body of snake
            }
            snakePoints.set(0, newStart);
            if(elongate){
                snakePoints.add(last);
                elongate = false ;
            }
        }

    }

    //2 condition that ends the game
    public boolean snakeCollision(){
        int x = this.getX();
        int y = this.getY();
        for(int i = 1; i < snakePoints.size() -1; i++){
            if(snakePoints.get(i).getX() == x && snakePoints.get(i).getY() == y)
                return true;
        }
        return false;
    }

    //create accessors for snake to move and elongate
    public boolean isMoving() {
        return isMoving;
    }

    public void setIsMoving(boolean b){
        isMoving = b;
    }
}


