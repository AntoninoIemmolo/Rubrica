import java.awt.event.MouseAdapter;
import javax.swing.*;

public class ClickerElimina extends MouseAdapter {

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        JList<String>list = App.getList();
        System.out.println( list.getSelectedValue());
        if(list.getSelectedValue() != null){
            JFrame f = new JFrame();
            f.setSize(450, 250);
            if( JOptionPane.showConfirmDialog(f,"Eliminare la persona "+list.getSelectedValue().split(" ")[0]
            +" "+list.getSelectedValue().split(" ")[0])==JOptionPane.YES_OPTION){
                Rubrica.remove(list.getSelectedValue());
                App.RemovePersonaUI(list.getSelectedValue());
            }
        }
        else{
            JFrame f = new JFrame();
            f.setSize(450, 250);
            JOptionPane.showMessageDialog(f,"Selezione prima il contatto da eliminare");
        }
        System.out.println("-premuto");
    }
}
