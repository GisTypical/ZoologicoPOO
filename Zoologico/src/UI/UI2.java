package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI2{
    public static JPanel panelLista;
    private JButton b1, b2, b3, b4, b5, volver;

    public UI2(){
        UI2.panelLista = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.b1 = new JButton("Lista Mamiferos");
        this.b1.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                UI3 terceraV = new UI3(1);
                UI.view.setContentPane(terceraV.getJPanel());
                UI.view.validate();
                UI.view.invalidate();
            }
        });
        this.b2 = new JButton("Lista Reptil");
        this.b2.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                UI3 terceraV = new UI3(2);
                UI.view.setContentPane(terceraV.getJPanel());
                UI.view.validate();
                UI.view.invalidate();
            }
        });
        this.b3 = new JButton("Lista Ave");
        this.b3.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                UI3 terceraV = new UI3(3);
                UI.view.setContentPane(terceraV.getJPanel());
                UI.view.validate();
                UI.view.invalidate();
            }
        });
        this.b4 = new JButton("Lista Anfibio");
        this.b4.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                UI3 terceraV = new UI3(4);
                UI.view.setContentPane(terceraV.getJPanel());
                UI.view.validate();
                UI.view.invalidate();
            }
        });
        this.b5 = new JButton("Lista Pez");
        this.b5.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                UI3 terceraV = new UI3(5);
                UI.view.setContentPane(terceraV.getJPanel());
                UI.view.validate();
                UI.view.invalidate();
            }
        });
        this.volver = new JButton("Volver");
        UI2.panelLista.add(b1);
        UI2.panelLista.add(b2);
        UI2.panelLista.add(b3);
        UI2.panelLista.add(b4);
        UI2.panelLista.add(b5);
        UI2.panelLista.add(volver);
        this.volver.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                UI.view.setContentPane(UI.getJPanel());
                UI.view.validate();
                UI.view.invalidate();
            }
        });
        UI2.panelLista.setPreferredSize(new Dimension(100, 100));
    }

    public static JPanel getJPanel(){
        return panelLista;
    }
}