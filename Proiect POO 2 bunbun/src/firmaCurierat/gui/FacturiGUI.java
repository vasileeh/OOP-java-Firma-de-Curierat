package firmaCurierat.gui;

import firmaCurierat.livrari.Livrare;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class FacturiGUI extends JFrame {
    private ArrayList<Livrare> livrari;

    public FacturiGUI(ArrayList<Livrare> livrari) {
        this.livrari = livrari;

        setTitle("Facturi");
        setSize(300, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        DefaultListModel<String> awbListModel = new DefaultListModel<>();
        JList<String> awbList = new JList<>(awbListModel);
        JScrollPane scrollPane = new JScrollPane(awbList);
        add(scrollPane, BorderLayout.CENTER);
        Random rnd=new Random();;

        JPanel panelDetalii = new JPanel(new GridLayout(0, 1));
        add(panelDetalii, BorderLayout.EAST);

        for (Livrare livrare : livrari) {
            awbListModel.addElement(livrare.getAwb());
        }

        awbList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selectedAWB = awbList.getSelectedValue();
                if (selectedAWB != null && !e.getValueIsAdjusting()) {
                    for (Livrare livrare : livrari) {
                        if (livrare.getAwb().equals(selectedAWB)) {
                            LocalDate dataLivrare = LocalDate.now().plusDays(3);
                            String pinLivrare = generatePIN();
                            String intervalOrar = "09:00 - 17:00";
                            JOptionPane.showMessageDialog(null,
                                    "AWB: " + livrare.getAwb() + "\n" +
                                            "Destinatar: " + livrare.getDestinatar() + "\n" +
                                            "Greutate: " + livrare.getGreutate() + " kg\n" +
                                            "Cartier: " + livrare.getCartier() + "\n" +
                                            "Curier: " + livrare.getCurier().getNume() + "\n" +
                                            "Telefon Curier: " + livrare.getCurier().getTelefon() + "\n" +
                                            "Status: " + livrare.getStatus() + "\n" +
                                            "Data estimată livrare: " + dataLivrare.toString() + "\n" +
                                            "Interval orar: " + intervalOrar + "\n" +
                                            "De plata: " + (rnd.nextInt(900)+100) + " lei, ramburs" +"\n" +
                                            "PIN Livrare: " + pinLivrare
                            );
                            break;
                        }
                    }
                }
            }
        });
        setVisible(true);
    }
    private String generatePIN() {
        Random random = new Random();
        int pin = random.nextInt(9000) + 1000;
        return String.valueOf(pin);
    }
}
