import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Albert on 2015-09-23.
 */
public class LevelBoard {
    public Image brick;
    public Image grass;
    public Image water;
    public Image iron;
    public Image bulletY;
    public Image bulletX;


    public LevelBoard() {
        loadImages();
    }
    //zamienia pliki na Image
    private void loadImages() {
        File imageFile1 = new File(
                "Graphic\\m.png");
        File imageFile2 = new File(
                "Graphic\\t.png");
        File imageFile3 = new File(
                "Graphic\\w.png");
        File imageFile5 = new File(
                "Graphic\\z.png");
        File imageFile6 = new File(
                "Graphic\\p1.png");
        File imageFile7 = new File(
                "Graphic\\p2.png");

        try {
            brick = ImageIO.read(imageFile1);
            grass = ImageIO.read(imageFile2);
            water = ImageIO.read(imageFile3);
            iron = ImageIO.read(imageFile5);
            bulletY = ImageIO.read(imageFile6);
            bulletX = ImageIO.read(imageFile7);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("za³adowano obrazki");
    }
}