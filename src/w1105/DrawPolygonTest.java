package w1105;

import javax.swing.*;
import java.awt.*;

public class DrawPolygonTest extends JFrame {
    static class MyPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.red);
            g.drawLine(10, 20, 480, 20);
            g.setColor(Color.green);
            g.drawOval(20, 30, 150, 100);
            g.setColor(Color.blue);
            g.fillOval(200, 30, 150, 100);
            g.setColor(Color.orange);
            g.fillOval(370, 30, 100, 100);
            g.setColor(Color.pink);
            g.drawRect(20, 160, 200, 150);
            g.setColor(Color.magenta);
            g.fillRect(250, 160, 200, 200);
            g.setColor(Color.black);
            g.fillRoundRect(280, 190, 140, 140, 20, 20);
            g.setColor(Color.yellow);
            int[] xPoints = {110, 30, 100};
            int[] yPoints = {180, 250, 250};
            g.drawPolygon(xPoints, yPoints, xPoints.length);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("도형 그리기");
        frame.setLayout(new CardLayout());

        MyPanel panel = new MyPanel();
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(250, 250);
        frame.setVisible(true);
    }
}