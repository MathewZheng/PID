import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {
    private final int width = 500;
    private final int height = 500;
    private Timer timer;
    private PID xVel = new PID(0.05, 0, 0, -5, 5);
    private PID yVel = new PID(0.05, 0, 0, -5, 5);
    private int x = 0;
    private int y = 0;
    private int targetX = 400;
    private int targetY = 400;

    public MyPanel(){
        this.setPreferredSize(new Dimension(width, height));
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawRect(x, y, 50, 50);
        g2D.setColor(new Color(125, 167, 116));
        g2D.fillRect(x, y, 50, 50);
        g2D.drawOval(targetX, targetY, 10, 10);
        g2D.setColor(new Color(0,0,0));
        g2D.fillOval(targetX, targetY, 10, 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double xVelocity = xVel.run(targetX, x);
        double yVelocity = yVel.run(targetY, y);
        System.out.println(xVelocity);
        System.out.println(yVelocity);
        x += xVel.run(targetX, x);
        y += yVel.run(targetY, y);
        repaint();
    }
}
