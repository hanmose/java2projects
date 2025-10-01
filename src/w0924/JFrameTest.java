package w0924;

public class JFrameTest extends javax.swing.JFrame {
    JFrameTest() {
        setTitle("처음 만드는 프레임");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new JFrameTest();
    }
}
