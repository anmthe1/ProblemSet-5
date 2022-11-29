import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Bird extends Rectangle{

    private BufferedImage image;

    public Bird(int x, int y, int width, int height) {
        super(x, y, width, height);

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        System.out.println("Select one of the following:");
        System.out.println("1 for Frog");
        System.out.println("2 for Corgi");
        System.out.println("3 for Bulldog");
        System.out.println("4 for Rabbit");
        System.out.println("5 for Random Roulette");

        Scanner scnr = new Scanner(System.in);
        int response = scnr.nextInt();
        String imageName = "";

        if(response ==5){
            Random rand = new Random();
            response = rand.nextInt(1,5);
        }
        if (response ==1) {
            imageName = "GroupPart/src/images.png";
        }
        if(response ==2){
            imageName = "GroupPart/src/corgi.jpg";
        }
        if (response ==3){
            imageName = "GroupPart/src/dawg.jpg";
        }
        if (response ==4) {
            imageName = "GroupPart/src/images.jpg";
        }



        try {
            image = ImageIO.read(new File(imageName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void draw(Graphics g) {
        //g.fillRect(this.x, this.y, this.width, this.height);
        g.drawImage(image, this.x, this.y, this.width, this.height, null);
    }
}
