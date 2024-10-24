package firmaCurierat.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirmaCurieratGUI extends JFrame {
    private JFrame vehiculeGUI;
    private CurieriGUI curieriGUI;
    private JFrame livrariGUI;

    public FirmaCurieratGUI() {
        setTitle("Firma de Curierat");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        ImageIcon icon = new ImageIcon("Pictures/WhatsApp_Image_2024-10-24_at_14.33.33_dd456ab0-removebg-preview.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(300, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JLabel imageLabel = new JLabel(scaledIcon);

        JButton btnVehicule = new JButton("Vehicule");
        btnVehicule.setPreferredSize(new Dimension(200, 80));
        JButton btnCurieri = new JButton("Curieri");
        btnCurieri.setPreferredSize(new Dimension(200, 80));
        JButton btnLivrari = new JButton("Livrari");
        btnLivrari.setPreferredSize(new Dimension(200, 80));

        add(imageLabel, gbc);
        add(btnVehicule, gbc);
        add(btnCurieri, gbc);
        add(btnLivrari, gbc);


        btnVehicule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeOtherWindows();
                if (vehiculeGUI == null) {
                    vehiculeGUI = new VehiculeGUI();
                }
                vehiculeGUI.setVisible(true);
            }
        });

        btnCurieri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeOtherWindows();
                if (curieriGUI == null) {
                    curieriGUI = new CurieriGUI();
                }
                curieriGUI.setVisible(true);
            }
        });

        btnLivrari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeOtherWindows();
                if (curieriGUI != null) {
                    livrariGUI = new LivrariGUI(curieriGUI.getCurieri());
                } else {
                    JOptionPane.showMessageDialog(null, "Te rog deschide fereastra Curieri mai intai.");
                }
                livrariGUI.setVisible(true);
            }
        });

        setVisible(true);
    }
    private void closeOtherWindows() {
        if (vehiculeGUI != null && vehiculeGUI.isVisible()) {
            vehiculeGUI.dispose();
        }
        if (curieriGUI != null && curieriGUI.isVisible()) {
            curieriGUI.dispose();
        }
        if (livrariGUI != null && livrariGUI.isVisible()) {
            livrariGUI.dispose();
        }
    }

    public static void main(String[] args) {
        new FirmaCurieratGUI();
    }
}
