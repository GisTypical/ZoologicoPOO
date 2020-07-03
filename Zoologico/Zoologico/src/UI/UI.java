package UI;

//imports
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class UI {
    private JFrame view;
    private JPanel panelLeft, panelRight, panelUpperR, panelLowerR;
    private Border border;

    public UI(){
        border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        this.view = new JFrame("Zoologico OS v2");
        this.view.setLayout(new GridBagLayout( ));
        PanelLeft();
        PanelRight();



        this.view.setBounds(500, 250, 450, 325);
        this.view.setVisible(true);
        this.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.view.setResizable(true);
    }

    private void PanelRight() {
        this.panelRight = new JPanel(new GridLayout(2,1));

        //Panel derecha arriba
        this.panelUpperR = new JPanel();
        this.panelUpperR.setLayout(new BoxLayout(panelUpperR, BoxLayout.Y_AXIS));
        this.panelUpperR.setAlignmentY(Component.CENTER_ALIGNMENT);
        TitledBorder titledBorderU = BorderFactory.createTitledBorder(border, "Tipo");
        this.panelUpperR.setBorder(titledBorderU);
        String tipo[] = {"Mamifero", "Ave", "Reptil", "Anfibio", "Pez"};
        for (int i = 0; i < tipo.length; i++) {
            this.panelUpperR.add(new JCheckBox(tipo[i]));
        }
        this.panelRight.add(panelUpperR, BorderLayout.CENTER);

        //Panel derecha abajo
        this.panelLowerR = new JPanel(new GridBagLayout());
        JButton b1 = new JButton("Agregar");
        this.panelLowerR.add(b1);
        this.panelRight.add(panelLowerR, BorderLayout.SOUTH);

        this.view.add(panelRight);
    }

    public void PanelLeft() {
        this.panelLeft = new JPanel(new FlowLayout(FlowLayout.CENTER));
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "Datos");
        this.panelLeft.setBorder(titledBorder);
        this.panelLeft.add(new JLabel("Nombre:"));
        this.panelLeft.add(new JTextField(8));
        this.panelLeft.add(new JLabel("Especie:"));
        this.panelLeft.add(new JTextField(10));
        this.panelLeft.add(new JLabel("Total:"));
        this.panelLeft.add(new JTextField(3));
        this.panelLeft.add(new JLabel("Comida:"));
        this.panelLeft.add(new JTextField(10));
        this.panelLeft.add(new JLabel("Comportamiento:"));
        this.panelLeft.add(new JTextField(10));
        //Constraints
        
        this.view.add(panelLeft);
    }
}