
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class Clicker implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("--clickato");
        JFrame f = App.getFrame();
        f.setVisible(true);

        System.out.println("-premuto");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("-rilasciato");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
