package UI;
//imports
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class UI2 {
    private JFrame view;
    private JPanel panel1, panel2, panel3;
    private Border border;
    private JButton b1, b2;
    private GridBagConstraints cns = new GridBagConstraints();

    public UI2(){
        border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        this.view = new JFrame("Zoologico OS v2");
        this.view.setLayout(new GridBagLayout());
        Panel();

        this.view.setBounds(500, 250, 450, 275);
        this.view.setVisible(true);
        this.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.view.setResizable(false);
    }

    public void Panel(){
        this.panel1 = new JPanel();
        this.panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        TitledBorder titleBorderL = BorderFactory.createTitledBorder(border,"«Datos Animal»");
        titleBorderL.setTitleJustification(TitledBorder.CENTER);
        this.panel1.setBorder(titleBorderL);
        this.panel1.add(new JLabel("Nombre:")); this.panel1.add(new JTextField(8));
        this.panel1.add(new JLabel("Especie:")); this.panel1.add(new JTextField(8));
        this.panel1.add(new JLabel("Total:")); this.panel1.add(new JTextField(8));
        this.panel1.add(new JLabel("Alimentación:")); this.panel1.add(new JTextField(8));
        this.panel1.add(new JLabel("Comportamiento:")); this.panel1.add(new JTextField(8));
        cns.gridx = 0; cns.gridy = 0; cns.gridwidth = 1; cns.gridheight = 2; cns.weightx = 1.0; cns.weighty = 1.0; cns.fill = GridBagConstraints.BOTH;
        this.view.add(panel1, cns);
        
        this.panel2 = new JPanel();
        this.panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
        TitledBorder titleBorderUR = BorderFactory.createTitledBorder(border,"«Tipo Animal»");
        titleBorderUR.setTitleJustification(TitledBorder.CENTER);
        this.panel2.setBorder(titleBorderUR);
        String tipo[] = {"Mamifero", "Reptil", "Ave", "Anfibio", "Pez"};
        for (int i = 0; i < tipo.length; i++) {
            this.panel2.add(new JCheckBox(tipo[i]));
        }
        this.panel2.add(new JLabel("Hola"));
        cns.gridx = 1; cns.gridy = 0; cns.gridwidth = 1; cns.gridheight = 1; cns.weightx = 1.0; cns.weighty = 1.0; cns.fill = GridBagConstraints.BOTH;
        this.view.add(panel2, cns);

        this.panel3 = new JPanel();
        this.panel3.setLayout(new BorderLayout());
        this.b1 = new JButton("Insertar animal");
        this.b1.setSize(10, 30);
        this.panel3.add(b1, BorderLayout.NORTH);
        this.b2 = new JButton("Ver listas sin agregar → ");
        this.b2.setSize(10, 30);
        this.panel3.add(b2, BorderLayout.CENTER);
        cns.gridx = 1; cns.gridy = 1; cns.gridwidth = 1; cns.gridheight = 1; cns.weightx = 1.0; cns.weighty = 1.0; cns.fill = GridBagConstraints.BOTH;
        this.view.add(panel3, cns);
    }
}