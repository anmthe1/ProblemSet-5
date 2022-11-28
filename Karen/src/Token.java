import java.awt.*;

public class Token { //create token placed randomly for snake to chase
    private int x,y,score;
    private Snake snake; //variable to check snake location

    public Token (Snake s){
        x = (int)(Math.random() * 395);
        y = (int)(Math.random() * 395);
        snake = s;
    }

    public void changePosition(){
        x = (int)(Math.random() * 395);
        y = (int)(Math.random() * 395);
    }
//create accessors
    public int getScore(){
         return score;
    }

    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x,y,6,6);
    }

    //collision?
    public boolean snakeCollision(){
        int snakeX = snake.getX() + 2; //center of rectangle
        int snakeY = snake.getY() + 2;
        if (snakeX >= x-1 && snakeX <= (x+7))
            if (snakeY >= y-1 && snakeY <= (y+7)){
                changePosition();
                score ++;
                snake.setElongate(true);
                return true;
            }
        return false;
    }

}
