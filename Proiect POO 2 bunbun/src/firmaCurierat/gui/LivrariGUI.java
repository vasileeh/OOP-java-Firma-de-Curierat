package firmaCurierat.gui;

import firmaCurierat.curieri.Curier;
import firmaCurierat.livrari.Livrare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class LivrariGUI extends JFrame {
    private ArrayList<Livrare> livrari = new ArrayList<>();
    private DefaultListModel<String> livrariListModel = new DefaultListModel<>();
    private JList<String> livrariList = new JList<>(livrariListModel);
    private ArrayList<Curier> curieri;

    public LivrariGUI(ArrayList<Curier> curieri) {
        this.curieri = curieri;

        setTitle("Livrari");
        setSize(800, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelAdaugare = new JPanel();
        JTextField destinatarField = new JTextField(10);
        JTextField greutateField = new JTextField(5);
        String[] cartiere = {"7 Noiembrie", "Centru", "Tudor Vladimirescu", "Unirii", "Dambu"};
        JComboBox<String> cartierBox = new JComboBox<>(cartiere);
        JButton adaugaButton = new JButton("Adauga Livrare");
        JButton facturiButton = new JButton("Facturi");

        panelAdaugare.add(new JLabel("Destinatar:"));
        panelAdaugare.add(destinatarField);
        panelAdaugare.add(new JLabel("Greutate colet:"));
        panelAdaugare.add(greutateField);
        panelAdaugare.add(new JLabel("Cartier:"));
        panelAdaugare.add(cartierBox);
        panelAdaugare.add(adaugaButton);
        panelAdaugare.add(facturiButton);

        add(panelAdaugare, BorderLayout.NORTH);

        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String destinatar = destinatarField.getText();
                double greutate;
                try {
                    greutate = Double.parseDouble(greutateField.getText().replace(",", "."));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Greutatea introdusa nu este valida.");
                    return;
                }

                String cartier = (String) cartierBox.getSelectedItem();
                Curier curierAles = null;
                for (Curier curier : curieri) {
                    if (curier.getCartier().equals(cartier)) {
                        if ((greutate > 20.0 && curier.getVehicul() instanceof firmaCurierat.vehicule.Camion) ||
                                (greutate <= 20.0 && curier.getVehicul() instanceof firmaCurierat.vehicule.Masina)) {
                            curierAles = curier;
                            break;
                        }
                    }
                }
                if (curierAles != null) {
                    String awb = generateAWB();
                    Livrare livrare = new Livrare(destinatar, greutate, cartier, curierAles, awb);
                    livrari.add(livrare);
                    livrariListModel.addElement(livrare.toString());
                    JOptionPane.showMessageDialog(null, "Expedierea AWB " + awb + " a fost colectata de firma noastra.");
                } else {
                    JOptionPane.showMessageDialog(null, "Nu exista curier disponibil pentru livrarea solicitata");
                }

                destinatarField.setText("");
                greutateField.setText("");
            }
        });
        facturiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FacturiGUI(livrari);
            }
        });

        setVisible(true);
    }
    private String generateAWB() {
        Random random = new Random();
        return "AWB-" + (random.nextInt(90000000) + 10000000);
    }
}
