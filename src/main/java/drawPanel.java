import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class drawPanel extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new drawPanel());
        frame.setVisible(true);
    }

    public boolean drag = false;
    public Point dragLocation = new Point();

    private JLabel test = new JLabel("Release");
    private JLabel eGetPoint = new JLabel();
    private JLabel dragLocationPoint = new JLabel();
    public JLabel showSize = new JLabel();
    private Cursor e_w_Cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
    private Cursor d_Cursor = new Cursor(Cursor.DEFAULT_CURSOR);

    public drawPanel() {
        setBounds(0, 0, 500, 500);
        setBackground(Color.WHITE);
        showSize.setText(getWidth() + "," + getHeight());
        add(showSize);
        add(test);
        add(eGetPoint);
        add(dragLocationPoint);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                test.setText("Drag");
                dragLocation = e.getPoint();
                dragLocationPoint.setText((int) (dragLocation.getX()) + "," + (int) (dragLocation.getY()));
                drag = true;
                setCursor(e_w_Cursor);
            }

            public void mouseReleased(MouseEvent e) {
                test.setText("Release");
                drag = false;
                setCursor(d_Cursor);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (drag) {
                    eGetPoint.setText(e.getX() + "," + e.getY());
                    showSize.setText(getWidth() + "," + getHeight());

                    if (getWidth() - 10 < dragLocation.getX() && dragLocation.getX() <= getWidth()) {
                        dragLocation = e.getPoint();
                        setSize(e.getX(), getHeight());
                        setCursor(e_w_Cursor);
                    }

                    if (getWidth() == e.getX()) {
                        setCursor(e_w_Cursor);
                    }
                }
            }

            public void mouseMoved(MouseEvent e) {
                if (getWidth() - 10 < e.getX() && e.getX() <= getWidth()) {
                    setCursor(e_w_Cursor);
                }
                else {
                    setCursor(d_Cursor);
                }
            }
        });
    }

}