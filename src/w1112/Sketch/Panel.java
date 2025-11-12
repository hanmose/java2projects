package w1112.Sketch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel {

    public Panel() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Sketch.x1 = e.getX();
                Sketch.y1 = e.getY();
            }

            public void mouseReleased(MouseEvent e) {
                Sketch.x2 = e.getX();
                Sketch.y2 = e.getY();
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x1 = Sketch.x1;
        int y1 = Sketch.y1;
        int x2 = Sketch.x2;
        int y2 = Sketch.y2;

        if (x1 > x2) { int tmp = x1; x1 = x2; x2 = tmp; }
        if (y1 > y2) { int tmp = y1; y1 = y2; y2 = tmp; }

        if (Sketch.radio1.isSelected())
            g.drawLine(x1, y1, x2, y2);
        else if (Sketch.radio2.isSelected())
            g.drawRect(x1, y1, x2 - x1, y2 - y1);
        else
            g.drawOval(x1, y1, x2 - x1, y2 - y1);
    }
}
