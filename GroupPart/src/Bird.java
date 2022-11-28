import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird extends Rectangle{

    private BufferedImage image;

    public Bird(int x, int y, int width, int height) {
        super(x, y, width, height);

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        String imageName = "GroupPart/src/dawg.jpg";

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
