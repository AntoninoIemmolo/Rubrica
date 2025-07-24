import java.awt.*;
import javax.swing.*;

public class App {
    private static final JFrame f = new JFrame("Rubrica App_v0.1");
    private static DefaultListModel<String> listModel=new DefaultListModel<>();
    private static JList<String> list;

    public static JFrame getFrame() {
        return f;
    }

    public static void main(String[] args) {
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gbl = new GridBagLayout();
        f.setLayout(gbl);

        // Pannello centrale con layout verticale e colore visibile
        GridBagConstraints layout = new GridBagConstraints();
        layout.gridx = 0;
        layout.gridy = 1;
        layout.gridwidth = 4;
        layout.gridheight= 1;
        layout.weightx = 0;
        layout.weighty= 1;
        layout.fill = GridBagConstraints.BOTH;
        layout.anchor = GridBagConstraints.WEST;


        for (int i = 0; i < 100; i++) {
            Rubrica.addPerona("Persona "+i, "a", "a", "a", "10");
            listModel.addElement(Rubrica.getPersonaStringList().getLast());
        }
        list = new JList<>(listModel);

        JButton nuovo = addButton(gbl,1, 0, "Nuovo", GridBagConstraints.WEST);
        JButton modifica = addButton(gbl,2, 0, "Modifica", GridBagConstraints.CENTER);
        JButton elimina = addButton(gbl,3, 0,"Elimina",GridBagConstraints.EAST);
        nuovo.addMouseListener(new ClickerNuovo());
        modifica.addMouseListener(new ClickerModifica());
        elimina.addMouseListener(new ClickerElimina());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        f.add(new JLabel("Azioni"), gbc);


        // Bottone sotto
        JButton button = new JButton("Aggiungi etichetta");
        button.addMouseListener(new Clicker());

        JScrollPane rubircaScrolElement = new JScrollPane(list);
        gbl.setConstraints(rubircaScrolElement, layout);
        f.add(rubircaScrolElement);

        f.setVisible(true);
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
    public static DefaultListModel<String> getListModel(){return listModel;}
    public static JList<String> getList(){return list;}
}
