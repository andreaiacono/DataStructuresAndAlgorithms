import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.Document;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 20/07/15
 * Time: 22.43
 */
public class TestFrame extends JFrame {

    public static void main(String[] args) {

        JEditorPane editorPane = new JEditorPane("text/html", "contains <a href=\"http://example.com\">link to example.com</a>");
        editorPane.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                System.out.println("CLICK");
                if (e.getEventType().equals(HyperlinkEvent.EventType.ENTERED)) try {
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().browse(e.getURL().toURI());
                    }
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }
                catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });
        editorPane.setEditable(false);

        JFrame frame = new JFrame("EditorPane Example");
        frame.add(editorPane);
        frame.setSize(300,200);
        frame.setVisible(true);
    }
}
