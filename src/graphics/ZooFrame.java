package graphics;
import java.awt.*;
import javax.swing.*;

/***
 * @author shaked asido
 */

public class ZooFrame extends JFrame {

    public ZooFrame() {

        setTitle("Zoo");
        setSize(1000, 650);
        add(new ZooPanel());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            ZooFrame open = new ZooFrame();
            open.setVisible(true);
        });
    }
}
