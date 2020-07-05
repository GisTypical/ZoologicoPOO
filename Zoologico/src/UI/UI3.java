package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI3 {
    private JPanel panelMostrar;
    private JTextArea mostrarLista;
    private JButton volver;
    public UI3 (int key) {
        this.panelMostrar = new JPanel(new BorderLayout());
        switch (key) {
            case 1:
                this.mostrarLista = new JTextArea(UI.getListaMamiferos());
                break;
            case 2:
                this.mostrarLista = new JTextArea(UI.getListaReptiles());
                break;
            case 3:
                this.mostrarLista = new JTextArea(UI.getListaAves());
                break;
            case 4:
                this.mostrarLista = new JTextArea(UI.getListaAnfibios());
                break;
            case 5:
                this.mostrarLista = new JTextArea(UI.getListaPeces());
                break;
            default:
                break;
        }
        JScrollPane scroll = new JScrollPane(mostrarLista);
        this.panelMostrar.add(scroll, BorderLayout.CENTER);
        this.volver = new JButton("Volver");
        this.volver.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                UI.view.setContentPane(UI2.getJPanel());
                UI.view.validate();
                UI.view.invalidate();
            }
        });
        this.panelMostrar.add(volver, BorderLayout.SOUTH);
    }

    public JPanel getJPanel(){
        return this.panelMostrar;
    }

}