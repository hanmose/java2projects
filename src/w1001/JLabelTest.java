package w1001;

import javax.swing.*;
import java.awt.*;

public class JLabelTest extends JFrame {
    public JLabelTest(){
        setTitle("JLabel Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] lblTests = {"한국폴리텍대학", "서울 정수캠퍼스", "인공지능소프트웨어과"};
        String[] locTexsts = {"North", "Center", "South"};
        Color[] lblBgColors = {Color.gray, Color.black, Color.darkGray};
        JLabel[] lbls = new JLabel[lblTests.length];
        for(int i=0;i<lblTests.length;i++){
            lbls[i] = new JLabel(lblTests[i], JLabel.CENTER);
            lbls[i].setForeground(Color.white);
            lbls[i].setBackground(lblBgColors[i]);
            lbls[i].setOpaque(true);
            add(lbls[i],locTexsts[i]);
        }

        Font font = new Font("맑은 고딕",Font.BOLD,30);
        lbls[2].setFont(font);

        setBounds(100, 100, 450, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JLabelTest();
    }
}
