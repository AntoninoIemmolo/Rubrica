import java.awt.*;
import javax.swing.*;

public class App {
    private static final JFrame f = new JFrame("Rubrica App_v0.1");
    private static final DefaultListModel<String> listModel=new DefaultListModel<>();
    private static JList<String> list;
    private static Persistance p;

    public static JFrame getFrame() {
        return f;
    }

    public static void main(String[] args) {

        createUi();
        p = new Persistance("Saves/informazioni.txt");
        p.loadSaves();
        
        
        list = new JList<>(listModel);
        addListToUI();

    }

    static JButton addButton(GridBagLayout gbl, int x, int y, String str, int alg) {
        JButton button = new JButton(str);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        gbc.gridheight= 1;
        gbc.weightx = 0;
        gbc.weighty= 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = alg;

        f.add(button,gbc);
        return button;
    }
    public static JList<String> getList(){return list;}

    private static void createUi(){
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gbl = new GridBagLayout();
        f.setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        f.add(new JLabel("Azioni"), gbc);

        // Pannello centrale con layout verticale e colore visibile
        JButton nuovo = addButton(gbl,1, 0, "Nuovo", GridBagConstraints.WEST);
        JButton modifica = addButton(gbl,2, 0, "Modifica", GridBagConstraints.CENTER);
        JButton elimina = addButton(gbl,3, 0,"Elimina",GridBagConstraints.EAST);
        nuovo.addMouseListener(new ClickerNuovo());
        modifica.addMouseListener(new ClickerModifica());
        elimina.addMouseListener(new ClickerElimina());


        JButton button = new JButton("Aggiungi etichetta");
        button.addMouseListener(new Clicker());

        

    }
    private static void addListToUI(){
        JScrollPane rubircaScrolElement = new JScrollPane(list);

        GridBagConstraints layout = new GridBagConstraints();
        layout.gridx = 0;
        layout.gridy = 1;
        layout.gridwidth = 4;
        layout.gridheight= 1;
        layout.weightx = 0;
        layout.weighty= 1;
        layout.fill = GridBagConstraints.BOTH;
        layout.anchor = GridBagConstraints.WEST;


        f.add(rubircaScrolElement,layout);
        f.setVisible(true);
    }
    public static void addPersonaUI(String entry){
        listModel.addElement(entry);
        p.refreshSaves();
    }
    public static void RemovePersonaUI(String entry){
        listModel.removeElement(entry);
        p.refreshSaves();
    }
    public static void RemovePersonaUI(int index){
        listModel.removeElement(index);
        p.refreshSaves();
    }
    public static void refreshPersonaUI(int index,String entry){
        listModel.set(index, entry);
        p.refreshSaves();
    }
}

