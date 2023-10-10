import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame{
    MyPanel panel;
    public MyFrame(){
        panel = new MyPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setTitle("First Try on GUI");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
