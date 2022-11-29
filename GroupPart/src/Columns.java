import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Columns extends Rectangle{
    private BufferedImage image;
    public Columns(int x, int y, int width, int height) {
        super(x, y, width, height);

        try {
            image = ImageIO.read(new File("GroupPart/src/Screenshot.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void draw(Graphics g) {
        //g.fillRect(this.x, this.y, this.width, this.height);
        g.drawImage(image, this.x, this.y, this.width, this.height, null);
    }


}
