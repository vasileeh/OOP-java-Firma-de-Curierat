package firmaCurierat.gui;

import firmaCurierat.vehicule.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehiculeGUI extends JFrame {
    private static ArrayList<Vehicul> vehicule = new ArrayList<>();
    private DefaultListModel<String> vehiculeListModel = new DefaultListModel<>();
    private JList<String> vehiculeList = new JList<>(vehiculeListModel);
    public VehiculeGUI() {
        setTitle("Vehicule");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelAdaugare = new JPanel();
        JTextField marcaField = new JTextField(10);
        String[] tipuriVehicule = {"Masina", "Camion"};
        JComboBox<String> tipVehiculBox = new JComboBox<>(tipuriVehicule);
        JButton adaugaButton = new JButton("Adauga Vehicul");

        panelAdaugare.add(new JLabel("Marca:"));
        panelAdaugare.add(marcaField);
        panelAdaugare.add(new JLabel("Tip Vehicul:"));
        panelAdaugare.add(tipVehiculBox);
        panelAdaugare.add(adaugaButton);

        add(panelAdaugare, BorderLayout.NORTH);
        add(new JScrollPane(vehiculeList), BorderLayout.CENTER);

        adaugaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = marcaField.getText();
                String tipVehicul = (String) tipVehiculBox.getSelectedItem();
                Vehicul vehicul;

                if (tipVehicul.equals("Masina")) {
                    vehicul = new Masina(marca);
                } else {
                    vehicul = new Camion(marca);
                }

                vehicule.add(vehicul);
                vehiculeListModel.addElement(vehicul.toString());
                marcaField.setText("");
            }
        });
        setVisible(true);
    }
    public static ArrayList<Vehicul> getVehicule() {
        return vehicule;
    }
}
