import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ActionListener{

    private JFrame frame;
    private JPanel panel;
    private final int top = 500;
    private final int left = 500;
    private final int bottom = 500;
    private final int right = 500;
    private Timer timer;
    private PID xVel = new PID(0.1, 0, 0, -5, 5);
    private PID yVel = new PID(0.1, 0, 0, -5, 5);
    private int x = 0;
    private int y = 0;
    private int targetX = 400;
    private int targetY = 400;

    public GUI(){
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(top, left));
        timer = new Timer(100, this);
        timer.start();

        frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("First Try on GUI");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawRect(x, y, 20, 20);
        g2D.setColor(new Color(125, 167, 116));
        g2D.fillRect(x, y, 20, 20);
        g2D.drawOval(targetX, targetY, 10, 10);
    }
    public static void main(String[] args){
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += 1;
        x += xVel.run(targetX, x);
        y += yVel.run(targetY, y);
        repaint();
    }
}
