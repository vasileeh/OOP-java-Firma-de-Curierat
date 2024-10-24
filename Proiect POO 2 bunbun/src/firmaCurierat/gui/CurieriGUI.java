package firmaCurierat.gui;

import firmaCurierat.curieri.Curier;
import firmaCurierat.vehicule.Vehicul;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CurieriGUI extends JFrame {
    private JTextField tfNume;
    private JTextField tfTelefon;
    private JComboBox<String> comboCartier;
    private JComboBox<Vehicul> comboVehicul;
    private DefaultListModel<String> curieriListModel;
    private ArrayList<Curier> curieri;

    public CurieriGUI() {
        setTitle("Curieri");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        curieri = new ArrayList<>();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 10, 10, 10);

        tfNume = new JTextField(15);
        tfTelefon = new JTextField(15);
        comboCartier = new JComboBox<>(new String[]{"7 Noiembrie", "Centru", "Tudor Vladimirescu", "Unirii", "Dambu"});

        comboVehicul = new JComboBox<>();
        ArrayList<Vehicul> vehiculeDisponibile = VehiculeGUI.getVehicule();
        for (Vehicul vehicul : vehiculeDisponibile) {
            comboVehicul.addItem(vehicul);
        }

        JButton btnAdaugaCurier = new JButton("Adauga curier");

        curieriListModel = new DefaultListModel<>();
        JList<String> listCurieri = new JList<>(curieriListModel);

        add(new JLabel("Nume:"), gbc);
        add(tfNume, gbc);
        add(new JLabel("Telefon:"), gbc);
        add(tfTelefon, gbc);
        add(new JLabel("Cartier:"), gbc);
        add(comboCartier, gbc);
        add(new JLabel("Vehicul:"), gbc);
        add(comboVehicul, gbc);
        add(btnAdaugaCurier, gbc);
        add(new JScrollPane(listCurieri), gbc);

        btnAdaugaCurier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = tfNume.getText();
                String telefon = tfTelefon.getText();
                String cartier = (String) comboCartier.getSelectedItem();
                Vehicul vehicul = (Vehicul) comboVehicul.getSelectedItem();

                if (nume.isEmpty() || telefon.isEmpty() || vehicul == null) {
                    JOptionPane.showMessageDialog(null, "Te rog completeaza toate campurile si selecteaza un vehicul");
                } else {
                    Curier curier = new Curier(nume, telefon, cartier, vehicul);
                    curieri.add(curier);
                    curieriListModel.addElement(curier.toString());
                    vehicul.setDisponibil(false);
                    comboVehicul.removeItem(vehicul);
                }
            }
        });
        setVisible(true);
    }
    public ArrayList<Curier> getCurieri() {
        return curieri;
    }
}
