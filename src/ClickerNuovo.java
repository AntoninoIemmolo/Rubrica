import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.*;

public class ClickerNuovo extends MouseAdapter {

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

        openWindow();
        System.out.println("-premuto");
    }

    private void openWindow() {
        JFrame f = new JFrame("Dettagli Del Nuovo Contatto");
        f.setSize(450, 250);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);

        GridBagLayout gbl = new GridBagLayout();
        f.setLayout(gbl);

        // GridBagConstraints for Labels
        GridBagConstraints gbcLabels = new GridBagConstraints();
        gbcLabels.gridx = 0;
        gbcLabels.gridwidth = 1;
        gbcLabels.gridheight = 1;
        gbcLabels.weightx = 0.0;
        gbcLabels.weighty = 0.0;
        gbcLabels.fill = GridBagConstraints.NONE;
        gbcLabels.anchor = GridBagConstraints.WEST;

        gbcLabels.insets = new Insets(5, 5, 5, 2); 

        GridBagConstraints gbcTextFields = new GridBagConstraints();
        gbcTextFields.gridx = 1;
        gbcTextFields.gridwidth = 1;
        gbcTextFields.gridheight = 1;
        gbcTextFields.weightx = 1.0;
        gbcTextFields.weighty = 0.0;
        gbcTextFields.fill = GridBagConstraints.HORIZONTAL;
        gbcTextFields.anchor = GridBagConstraints.WEST;
        gbcTextFields.insets = new Insets(5, 0, 5, 5); 

        gbcLabels.gridy = 0;
        f.add(new JLabel("Nome:"), gbcLabels);
        gbcLabels.gridy = 1;
        f.add(new JLabel("Cognome:"), gbcLabels);
        gbcLabels.gridy = 2;
        f.add(new JLabel("Telefono:"), gbcLabels);
        gbcLabels.gridy = 3;
        f.add(new JLabel("Indirizzo:"), gbcLabels);
        gbcLabels.gridy = 4;
        f.add(new JLabel("Età:"), gbcLabels);

        JTextField textNome = new JTextField(20);
        gbcTextFields.gridy = 0;
        f.add(textNome, gbcTextFields);

        JTextField textCnome = new JTextField(20);
        gbcTextFields.gridy = 1;
        f.add(textCnome, gbcTextFields);

        JTextField textTel = new JTextField(20);
        gbcTextFields.gridy = 2;
        f.add(textTel, gbcTextFields);

        JTextField textIndr = new JTextField(20);
        gbcTextFields.gridy = 3;
        f.add(textIndr, gbcTextFields);

        JTextField textEtà = new JTextField(20);
        gbcTextFields.gridy = 4;
        gbcTextFields.weighty = 1.0;
        f.add(textEtà, gbcTextFields);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveButton = new JButton("Salva");
        JButton annullaButton = new JButton("Annulla");
        buttonPanel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Persona p = null;
                System.out.println(textNome.getText());
                p = Rubrica.addPerona(textNome.getText(), textCnome.getText(), textIndr.getText(), textTel.getText(), textEtà.getText());
                App.addPersonaUI(p.toStringMinInfo());

                f.setVisible(false);
                f.dispose();
            }
        });
        buttonPanel.add(annullaButton);
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("annulla");
                f.setVisible(false);
                f.dispose();
            }
        });


        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.gridx = 0;
        gbcButtons.gridy = 5;
        gbcButtons.gridwidth = 2;
        gbcButtons.weightx = 1.0;
        gbcButtons.weighty = 0.0;
        gbcButtons.fill = GridBagConstraints.HORIZONTAL;
        gbcButtons.anchor = GridBagConstraints.SOUTH;
        gbcButtons.insets = new Insets(10, 5, 5, 5);

        f.add(buttonPanel, gbcButtons);

        f.pack();
        f.setVisible(true);

    }
}


