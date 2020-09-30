package ui;

import javax.swing.*;

import ui.ui1.*;

public class Frame {

    private JFrame ventana;

    public Frame() {
        this.ventana = new JFrame("Zoologico OS v2");

        UI ui = new UI(ventana);

        this.ventana.add(ui);
        
        new Hilo();


        this.ventana.setBounds(700, 200, 600, 275);
        this.ventana.setVisible(true);
        this.ventana.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.ventana.setResizable(false);
    }
}
