package w1001;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextTest extends JFrame {

    JTextField txt;

    public JTextTest() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = screenSize.width / 2;
        int y = screenSize.height / 2;

        setLayout(new FlowLayout(FlowLayout.CENTER));
        setTitle("JText Test");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btn = new JButton("확인");
        btn.addActionListener(btnListener);
        add(btn);

        txt = new JTextField(20);
        add(txt);

        setBounds(x-450/2, y-300/2, 450, 300);
        setVisible(true);
    }


    ActionListener btnListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,  txt.getText()+ "가 입력되었습니다");
        }
    };

    public static void main(String[] args) {
        new JTextTest();
    }
}
