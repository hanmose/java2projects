import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

public class BareMetalColorTrigger {

    private static volatile boolean isRunning = false;
    private static Thread workerThread = null;
    private static volatile Integer targetRgb = null;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Trigger");
        frame.setSize(260, 80);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(new JLabel("F2: 목표색, F8: 시작, F9: 중지, ESC: 종료", SwingConstants.CENTER));

        JRootPane root = frame.getRootPane();
        InputMap im = root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = root.getActionMap();

        im.put(KeyStroke.getKeyStroke("F2"), "PICK");
        am.put("PICK", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickTarget();
            }
        });

        im.put(KeyStroke.getKeyStroke("F8"), "START");
        am.put("START", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startWorker();
            }
        });

        im.put(KeyStroke.getKeyStroke("F9"), "STOP");
        am.put("STOP", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRunning = false;
            }
        });

        im.put(KeyStroke.getKeyStroke("ESCAPE"), "EXIT");
        am.put("EXIT", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRunning = false;
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    private static void pickTarget() {
        try {
            PointerInfo pi = MouseInfo.getPointerInfo();
            if (pi == null) return;
            Point p = pi.getLocation();
            Robot robot = new Robot();
            targetRgb = robot.getPixelColor(p.x, p.y).getRGB();
            System.out.println("목표 색 RGB: " + targetRgb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startWorker() {
        if (targetRgb == null || isRunning) return;
        isRunning = true;

        workerThread = new Thread(() -> {
            try {
                Robot robot = new Robot();
                Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                int prev = Integer.MIN_VALUE;

                while (isRunning) {
                    PointerInfo pi = MouseInfo.getPointerInfo();
                    if (pi == null) continue;

                    Point p = pi.getLocation();
                    int rgb = robot.getPixelColor(p.x, p.y).getRGB();

                    // 이전 색 != 목표색, 현재색 == 목표색 → 클릭 한 번
                    if (rgb == targetRgb && prev != targetRgb) {
                        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    }

                    prev = rgb;
                    // 절대 sleep 없음
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        workerThread.start();
    }
}
