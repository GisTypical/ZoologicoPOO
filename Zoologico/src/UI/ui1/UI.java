package UI.ui1;

import javax.swing.*;

import UI.*;
import cliente.Hilo;
import eventos.Insertar;
import zoo.DB;

import java.awt.*;
import java.awt.event.*;

public class UI extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel confirmacion;
    private GridBagConstraints cns = new GridBagConstraints();
    private int key = 1;

    public UI(JFrame ventana) {
        this.setLayout(new GridBagLayout());
        paneles(ventana);

        new Hilo();
    }

    public void paneles(JFrame ventana) {

        DB.getInstances().setConfirmacion(confirmacion);

        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        LeftPanel lP = new LeftPanel();
        cns.gridx = 0;
        cns.gridy = 0;
        cns.gridwidth = 1;
        cns.gridheight = 2;
        cns.weightx = 1.0;
        cns.weighty = 1.0;
        cns.fill = GridBagConstraints.BOTH;
        this.add(lP, cns);
        Insertar ins = new Insertar(lP.getTFN(), lP.getTFE(), lP.getTFA(), lP.getTFT(), lP.getTFC());

        // PANEL 2

        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));

        ButtonGroup group = new ButtonGroup();
        // Instanciar los JRadioButton
        JRadioButton radioMamifero = new JRadioButton("Mamifero", true);
        JRadioButton radioReptil = new JRadioButton("Reptil");
        JRadioButton radioAve = new JRadioButton("Ave");
        JRadioButton radioAnfibio = new JRadioButton("Anfibio");
        JRadioButton radioPez = new JRadioButton("Pez");
        // Agruparlos para solo elegir 1
        group.add(radioMamifero);
        group.add(radioReptil);
        group.add(radioAve);
        group.add(radioAnfibio);
        group.add(radioPez);
        // Añadirlos al panel
        panel2.add(radioMamifero);
        panel2.add(radioReptil);
        panel2.add(radioAve);
        panel2.add(radioAnfibio);
        panel2.add(radioPez);

        // Añadir acciones a los RadioButtons
        radioMamifero.addActionListener((ActionEvent event) -> ins.setkey(1));
        radioReptil.addActionListener((ActionEvent event) -> ins.setkey(2));
        radioAve.addActionListener((ActionEvent event) -> ins.setkey(3));
        radioAnfibio.addActionListener((ActionEvent event) -> ins.setkey(4));
        radioPez.addActionListener((ActionEvent event) -> ins.setkey(5));

        this.confirmacion = new JLabel();
        this.confirmacion.setVisible(false);
        panel2.add(this.confirmacion);
        cns.gridx = 1;
        cns.gridy = 0;
        cns.gridwidth = 1;
        cns.gridheight = 1;
        cns.weightx = 1.0;
        cns.weighty = 1.0;
        cns.fill = GridBagConstraints.BOTH;
        this.add(panel2, cns);

        // PANEL 3

        panel3.setLayout(new BorderLayout());
        JButton b1 = new JButton("Insertar animal");
        b1.addActionListener(ins);
        panel3.add(b1, BorderLayout.NORTH);
        JButton b2 = new JButton("Ver listas ->");
        b2.addActionListener((ActionEvent event) -> {
            UI2 ui2 = new UI2(ventana);
            ui2.setConfirmacion(this.confirmacion);
            ventana.setContentPane(ui2.getJPanel());
            ventana.validate();
            ventana.invalidate();
        });
        panel3.add(b2, BorderLayout.CENTER);
        cns.gridx = 1;
        cns.gridy = 1;
        cns.gridwidth = 1;
        cns.gridheight = 1;
        cns.weightx = 1.0;
        cns.weighty = 1.0;
        cns.fill = GridBagConstraints.BOTH;
        this.add(panel3, cns);
    }

    // Getters
    public JPanel getJPanel() {
        return this;
    }
}