import java.awt.event.MouseAdapter;
import javax.swing.*;

public class ClickerElimina extends MouseAdapter {

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        JList<String>list = App.getList();
        int selectedItem=list.getSelectedIndex();
        System.out.println( list.getSelectedValue());
        if(list.getSelectedValue() != null){
            Rubrica.remove(list.getSelectedValue());
            App.RemovePersonaUI(list.getSelectedValue());
        }
        System.out.println("-premuto");
    }
}
