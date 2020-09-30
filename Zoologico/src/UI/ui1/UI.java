package ui.ui1;

import eventos.UIEvent;
import ui.*;
import zoo.DB;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class UI extends JPanel {

    private static final long serialVersionUID = 1L;

    JLabel confirmacion = new JLabel();

    private GridBagConstraints cns = new GridBagConstraints();

    public UI(JFrame ventana) {
        this.setLayout(new GridBagLayout());
        paneles(ventana);
    }

    public void paneles(JFrame ventana) {
        

        LeftPanel lP = new LeftPanel();
        this.setGBCns(0, 0, 1, 2, 1.0, 1.0, GridBagConstraints.BOTH);
        this.add(lP, cns);
        UIEvent ins = new UIEvent(lP.getTFN(), lP.getTFE(), lP.getTFA(), lP.getTFT(), lP.getTFC());

        // PANEL TOP RIGHT
        JPanel topRight = new JPanel();
        topRight.setLayout(new BoxLayout(topRight, BoxLayout.PAGE_AXIS));
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "(Datos Animal)");
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        topRight.setBorder(titleBorder);

        // Instanciar los JRadioButton
        JRadioButton radioMamifero = new JRadioButton("Mamifero", true);
        JRadioButton radioReptil = new JRadioButton("Reptil");
        JRadioButton radioAve = new JRadioButton("Ave");
        JRadioButton radioAnfibio = new JRadioButton("Anfibio");
        JRadioButton radioPez = new JRadioButton("Pez");

        // Agruparlos para solo elegir 1
        ButtonGroup group = new ButtonGroup();
        group.add(radioMamifero);
        group.add(radioReptil);
        group.add(radioAve);
        group.add(radioAnfibio);
        group.add(radioPez);

        // Añadirlos al panel
        topRight.add(radioMamifero);
        topRight.add(radioReptil);
        topRight.add(radioAve);
        topRight.add(radioAnfibio);
        topRight.add(radioPez);

        // Añadir acciones a los RadioButtons
        radioMamifero.addActionListener((ActionEvent event) -> ins.setkey(1));
        radioReptil.addActionListener((ActionEvent event) -> ins.setkey(2));
        radioAve.addActionListener((ActionEvent event) -> ins.setkey(3));
        radioAnfibio.addActionListener((ActionEvent event) -> ins.setkey(4));
        radioPez.addActionListener((ActionEvent event) -> ins.setkey(5));

        this.confirmacion = new JLabel();
        DB.getInstances().setConfirmacion(this.confirmacion);
        this.confirmacion.setVisible(false);
        topRight.add(this.confirmacion);
        this.setGBCns(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.BOTH);
        cns.fill = GridBagConstraints.BOTH;
        this.add(topRight, cns);

        // PANEL 3
        JPanel botRight = new JPanel();
        botRight.setLayout(new BorderLayout());
        JButton b1 = new JButton("Insertar animal");
        b1.addActionListener(ins);
        botRight.add(b1, BorderLayout.NORTH);
        JButton b2 = new JButton("Ver listas ->");
        botRight.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        b2.addActionListener((ActionEvent event) -> {
            UI2 ui2 = new UI2(ventana);
            ui2.setConfirmacion(this.confirmacion);
            ventana.setContentPane(ui2.getJPanel());
            ventana.validate();
            ventana.invalidate();
        });

        botRight.add(b2, BorderLayout.CENTER);
        this.setGBCns(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.BOTH);
        this.add(botRight, cns);
    }

    private void setGBCns(int cns1, int cns2, int cns3, int cns4, double cns5, double cns6, int cns7) {
        this.cns.gridx = cns1;
        this.cns.gridy = cns2;
        this.cns.gridwidth = cns3;
        this.cns.gridheight = cns4;
        this.cns.weightx = cns5;
        this.cns.weighty = cns6;
        this.cns.fill = cns7;
    }

    // Getters
    public JPanel getJPanel() {
        return this;
    }
}