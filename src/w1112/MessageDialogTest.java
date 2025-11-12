package w1112;

import center_frame.CenterFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageDialogTest extends JFrame implements ActionListener {
    String btnStrs[] = {"Plain", "Warning", "Information"};
    JButton buttons[] = new JButton[btnStrs.length];

    public MessageDialogTest() {
        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);

        for (int i = 0; i < btnStrs.length; i++) {
            buttons[i] = new JButton(btnStrs[i]);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        setTitle("메시지대화상자 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterFrame cf = new CenterFrame(500, 400);
        setLocation(cf.getX(), cf.getY());
        setBounds(cf.getX(), cf.getY(), cf.getFw(), cf.getFh());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    };

    public static void main(String[] args) {
        new MessageDialogTest();
    }
}
