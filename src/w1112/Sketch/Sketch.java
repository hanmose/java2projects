package w1112.Sketch;

import javax.swing.*;
import java.awt.*;

public class Sketch {
    static int x1, y1, x2, y2;
    static JRadioButton radio1, radio2, radio3;

    public static void main(String[] args) {
        JFrame frame = new JFrame("그림판");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        radio1 = new JRadioButton("선");
        radio2 = new JRadioButton("사각형");
        radio3 = new JRadioButton("타원");
        radio1.setBounds(50, 0, 80, 30);
        radio2.setBounds(150, 0, 80, 30);
        radio3.setBounds(250, 0, 80, 30);
        frame.add(radio1);
        frame.add(radio2);
        frame.add(radio3);

        ButtonGroup grp = new ButtonGroup();
        grp.add(radio1);
        grp.add(radio2);
        grp.add(radio3);
        radio1.setSelected(true);

        Panel panel = new Panel();
        panel.setBackground(Color.YELLOW);
        panel.setBounds(0, 30, 500, 470);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
