package ui;

import javax.swing.*;

import ui.ui1.*;

import java.awt.*;
import java.awt.event.*;

public class UI2 extends JPanel{

    private static final long serialVersionUID = 1L;
    private JLabel confirmacion;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton volver;

    public UI2(JFrame ventana) {
        this.setLayout(new GridLayout(6, 1));
        this.setSize(300, 500);
        this.setBorder(BorderFactory.createEmptyBorder(10, 200, 10, 200));
        this.b1 = new JButton("Lista Mamiferos");
        this.b1.addActionListener((ActionEvent e) -> {
                UI3 ui3;
                ui3 = new UI3(1, ventana);
                ventana.setContentPane(ui3.getJPanel());
                ventana.validate();
                ventana.invalidate();
            }
        );
        this.b2 = new JButton("Lista Reptiles");
        this.b2.addActionListener((ActionEvent e) -> {
                UI3 ui3;
                ui3 = new UI3(2, ventana);
                ventana.setContentPane(ui3.getJPanel());
                ventana.validate();
                ventana.invalidate();
            }
        );
        this.b3 = new JButton("Lista Aves");
        this.b3.addActionListener((ActionEvent e) -> {
                UI3 ui3;
                ui3 = new UI3(3, ventana);
                ventana.setContentPane(ui3.getJPanel());
                ventana.validate();
                ventana.invalidate();
            }
        );
        this.b4 = new JButton("Lista Anfibios");
        this.b4.addActionListener((ActionEvent e) -> {
                UI3 ui3;
                ui3 = new UI3(4, ventana);
                ventana.setContentPane(ui3.getJPanel());
                ventana.validate();
                ventana.invalidate();
            }
        );
        this.b5 = new JButton("Lista Peces");
        this.b5.addActionListener((ActionEvent e) -> {
                UI3 ui3 = new UI3(5, ventana);
                ventana.setContentPane(ui3.getJPanel());
                ventana.validate();
                ventana.invalidate();
            }
        );
        this.volver = new JButton("Volver");
        this.volver.addActionListener((ActionEvent e) -> {
                UI ui1 = new UI(ventana);
                ventana.setContentPane(ui1.getJPanel());
                ventana.validate();
                ventana.invalidate();
                confirmacion.setVisible(false);
            }
        );
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        this.add(volver);
        this.setPreferredSize(new Dimension(100, 100));
    }

    public void setConfirmacion(JLabel confirmacion){
        this.confirmacion = confirmacion;
    }

    public JPanel getJPanel(){
        return this;
    }

}