import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//create class that extends JFrame
public class SnakeGame extends JFrame implements Runnable, KeyListener { //KeyListener enables users to access keyboards
    public Snake snake;
    public Thread thread;
    boolean gameOver;
    public Token token;
    public SnakeGame() {
        this.setSize(400,400);
        gameOver = false;
        snake = new Snake();
        token = new Token(snake);
        this.setTitle("Snake Game");
        this.setVisible(true);//required for Graphic to run (be visible)
        this.addKeyListener(this);
        thread = new Thread(this);
        thread.start();
    }

    // Create class with graphics
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 400, 400);
        //graphics when game is over
        System.out.println(gameOver);
        if(!gameOver) {
            snake.draw(g);
            token.draw(g);
        }
        else{
            g.setColor(Color.red);
            g.drawString("Gamer over", 180, 150);
            g.drawString( "Score = " + token.getScore(), 180, 170);
        }
    }

    // Create class that updates the graphics
    public void update(Graphics g) {
        paint(g);
        System.out.println("In update()");
    }

    // Create class that repaints graphics
    public void repaint(Graphics g) {
        // Color color = Color.cyan;
       // g.setColor(color);
        repaint(g);
        System.out.println("In repaint()");
    }

    public void run() {

        for (;;){
            if (!gameOver) {
                snake.move();
                this.checkGameOver();
                token.snakeCollision();
            }
            this.repaint();
            try{
                thread.sleep(40);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    // create main method to run code
    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
        if(!snake.isMoving()){
            System.out.println("Snake not moving");
            if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_RIGHT){
                System.out.println("snake moving");
                snake.setIsMoving(true);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            if(snake.getYDir() != 1){ // 1 = moving up
                snake.setyDir(-1);
                snake.setXDir(0);
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            if(snake.getYDir() != -1){
                snake.setyDir(1);
                snake.setXDir(0);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(snake.getXDir() != 1){
                snake.setXDir(-1);
                snake.setyDir(0);
            }

        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(snake.getXDir()!= -1){
                snake.setXDir(1);
                snake.setyDir(0);
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }

//conditions that end the game
    public void checkGameOver() {
        if (snake.getX() < 0 || snake.getX() > 396) {
            gameOver = true;
        }
        if (snake.getY() < 0 || snake.getY() > 396) {
            gameOver = true;
        }
        if(snake.snakeCollision()){
            gameOver = true;
        }
    }


}
