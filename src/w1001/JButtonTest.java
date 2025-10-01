package w1001;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonTest extends JFrame {
    public JButtonTest() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setTitle("JButton Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] lblTexts = {"First", "Second", "Third", "Fourth", "Fifth"};
        JButton[] btn = new JButton[lblTexts.length];

        for(int i=0;i<btn.length;i++){
            btn[i] = new JButton(lblTexts[i]);
            btn[i].addActionListener(btnListener);
            add(btn[i]);
        }




        setBounds(100, 100, 450, 300);
        setVisible(true);

    }

    ActionListener btnListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, e.getActionCommand()+"버튼을 선택했습니다.");
        }
    };

    public static void main(String[] args) {
        new JButtonTest();
    }
}
