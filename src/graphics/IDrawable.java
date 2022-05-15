package graphics;
import java.awt.Graphics;

/***
 * @author shaked asido
 */

public interface IDrawable {
    String PICTURE_PATH = "C:\\Users\\david\\AnimalAndPlants.w1\\graphics\\";
    void loadImages(String nm);
    void drawObject (Graphics g);
    String getColor();

}