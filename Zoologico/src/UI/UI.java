package UI;

//imports
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import clases.*;

public class UI {
    public static ArrayList<Mamifero> mamiferos;
    public static ArrayList<Anfibio> anfibios;
    public static ArrayList<Pez> peces;
    public static ArrayList<Reptil> reptiles;
    public static ArrayList<Ave> aves;
    public static JFrame view;
    private JLabel confirmacion;
    private static JPanel panelGod, panel1, panel2, panel3;
    private Border border;
    private JTextField textFieldN, textFieldE, textFieldA, textFieldC, textFieldT;
    private JButton b1, b2;
    private GridBagConstraints cns = new GridBagConstraints();
	private int key;

    public UI(){

        Pez p1 = new Pez("Pez Payaso", "A. chagosensis", "Herbivoro", 10);
        p1.setComportamiento("Nadar\n");

        Pez p2 = new Pez("Pez Espada", "X. gladius", "Carnivoro", 5);
        p2.setComportamiento("Nadar\n");

        Pez p3 = new Pez("Tiburon Blanco", "C. carcharias", "Carnivoro", 2);
        p3.setComportamiento("Cazar\n");

        Mamifero m1 = new Mamifero("Guepardo", "A. jubatus", "Carnivoro", 3);
        m1.setComportamiento("Correr\n");

        Mamifero m2 = new Mamifero("Oso Pardo", "U. arctos", "Omnivoro", 4);
        m2.setComportamiento("Cazar\n");

        Mamifero m3 = new Mamifero("Elefante", "L. cyclotis", "Herbivoro", 3);
        m3.setComportamiento("Caminar\n");

        Ave a1 = new Ave("Pinguino Rey", "A. patagonicus", "Carnivoro", 6);
        a1.setComportamiento("Nadar\n");

        Ave a2 = new Ave("avestruz", "S. camelus", "Herbivoro", 4);
        a2.setComportamiento("Correr\n");

        Ave a3 = new Ave("Pavo Real", "P. cristatus", "Herbivoro", 1);
        a3.setComportamiento("Caminar\n");

        Reptil r1 = new Reptil("Cocodrilo", "C. crocodilus", "Carnivoro", 2);
        r1.setComportamiento("Caminar y Nadar\n");

        Reptil r2 = new Reptil("Morrocoy", "C. carbonaria", "Herbivora", 6);
        r2.setComportamiento("Caminar\n");

        Reptil r3 = new Reptil("Camaleon", "C. chamaeleon", "Insectivoro", 9);
        r3.setComportamiento("Camuflajear\n");

        Anfibio an1 = new Anfibio("Sapo Comun", "B. bufo", "Insectivoro", 14);
        an1.setComportamiento("Saltar\n");

        Anfibio an2 = new Anfibio("Rana Dorada", "P. terribilis", "Insectivoro", 1);
        an2.setComportamiento("Envenenar\n");

        Anfibio an3 = new Anfibio("Cecilias", "P. terribilis", "Insectivoro", 7);
        an3.setComportamiento("Arrastrar\n");

        //Creacion de Arraylists
        mamiferos = new ArrayList<Mamifero>();
        anfibios = new ArrayList<Anfibio>();
        peces = new ArrayList<Pez>();
        reptiles = new ArrayList<Reptil>();
        aves = new ArrayList<Ave>();

        //Agregar a los Arraylists
        mamiferos.add(m1);
        mamiferos.add(m2);
        mamiferos.add(m3);
        anfibios.add(an1);
        anfibios.add(an2);
        anfibios.add(an3);
        peces.add(p1);
        peces.add(p2);
        peces.add(p3);
        reptiles.add(r1);
        reptiles.add(r2);
        reptiles.add(r3);
        aves.add(a1);
        aves.add(a2);
        aves.add(a3);
        border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        UI.view = new JFrame("Zoologico OS v2");
        UI.panelGod = new JPanel();
        UI.panelGod.setLayout(new GridBagLayout());
        Paneles();
        UI.view.add(panelGod); 

        UI.view.setBounds(500, 250, 450, 275);
        UI.view.setVisible(true);
        UI.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI.view.setResizable(false);
    }

    public void Paneles(){
        
        UI.panel1 = new JPanel();
        UI.panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        TitledBorder titleBorderL = BorderFactory.createTitledBorder(border,"«Datos Animal»");
        titleBorderL.setTitleJustification(TitledBorder.CENTER);
        UI.panel1.setBorder(titleBorderL);
        //Instanciar los Labels y los TextFields
        UI.panel1.add(new JLabel("Nombre:")); this.textFieldN = new JTextField(); UI.panel1.add(textFieldN);
        UI.panel1.add(new JLabel("Especie:")); this.textFieldE = new JTextField(); UI.panel1.add(textFieldE); 
        UI.panel1.add(new JLabel("Total de animales:")); this.textFieldT = new JTextField(); UI.panel1.add(textFieldT);
        UI.panel1.add(new JLabel("Alimentación:")); this.textFieldA = new JTextField(); UI.panel1.add(textFieldA); 
        UI.panel1.add(new JLabel("Comportamiento:")); this.textFieldC = new JTextField(); UI.panel1.add(textFieldC);
        cns.gridx = 0; cns.gridy = 0; cns.gridwidth = 1; cns.gridheight = 2; cns.weightx = 1.0; cns.weighty = 1.0; cns.fill = GridBagConstraints.BOTH;
        UI.panelGod.add(panel1, cns);
        
        UI.panel2 = new JPanel();
        UI.panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
        TitledBorder titleBorderUR = BorderFactory.createTitledBorder(border,"«Tipo Animal»");
        titleBorderUR.setTitleJustification(TitledBorder.CENTER);
        UI.panel2.setBorder(titleBorderUR);
        ButtonGroup group = new ButtonGroup();
        //Instanciar los JRadioButton
        JRadioButton radioMamifero = new JRadioButton("Mamifero");
        JRadioButton radioReptil = new JRadioButton("Reptil");
        JRadioButton radioAve = new JRadioButton("Ave");
        JRadioButton radioAnfibio = new JRadioButton("Anfibio");
        JRadioButton radioPez = new JRadioButton("Pez");
        //Agruparlos para solo elegir 1
        group.add(radioMamifero);
        group.add(radioReptil);
        group.add(radioAve);
        group.add(radioAnfibio);
        group.add(radioPez);
        //Añadirlos al panel
        panel2.add(radioMamifero);
        panel2.add(radioReptil);
        panel2.add(radioAve);
        panel2.add(radioAnfibio);
        panel2.add(radioPez);
        //Añadir acciones a los RadioButtons
        radioMamifero.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				key = 1;
            }
        });
        radioReptil.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				key = 2;
            }
        });
        radioAve.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				key = 3;
            }
        });
        radioAnfibio.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				key = 4;
            }
        });
        radioPez.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				key = 5;
            }
        });
        confirmacion = new JLabel("Insertado!");
        this.confirmacion.setVisible(false);
        UI.panel2.add(this.confirmacion);
        cns.gridx = 1; cns.gridy = 0; cns.gridwidth = 1; cns.gridheight = 1; cns.weightx = 1.0; cns.weighty = 1.0; cns.fill = GridBagConstraints.BOTH;
        UI.panelGod.add(panel2, cns);
        UI.panel3 = new JPanel();
        UI.panel3.setLayout(new BorderLayout());
        this.b1 = new JButton("Insertar animal");
        this.b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nombre = textFieldN.getText();
                String especie = textFieldE.getText();
                String total = textFieldT.getText();
                String alimentacion = textFieldA.getText();
                int totalInt = Integer.parseInt(total);
                String comportamiento = textFieldC.getText();
                switch (key) {
                    case 1:
                        Mamifero mamiferoUsuario = new Mamifero(nombre, especie, alimentacion, totalInt);
                        mamiferoUsuario.setComportamiento(comportamiento);
                        mamiferos.add(mamiferoUsuario);
                        break;
                    case 2:
                        Reptil reptilUsuario = new Reptil(nombre, especie, alimentacion, totalInt);
                        reptilUsuario.setComportamiento(comportamiento);
                        reptiles.add(reptilUsuario);
                        break;
                    case 3:
                        Ave aveUsuario = new Ave(nombre, especie, alimentacion, totalInt);
                        aveUsuario.setComportamiento(comportamiento);
                        aves.add(aveUsuario);
                        break;
                    case 4:
                        Anfibio anfibioUsuario = new Anfibio(nombre, especie, alimentacion, totalInt);
                        anfibioUsuario.setComportamiento(comportamiento);
                        anfibios.add(anfibioUsuario);
                        break;
                    case 5:
                        Pez pezUsuario = new Pez(nombre, especie, alimentacion, totalInt);
                        pezUsuario.setComportamiento(comportamiento);
                        peces.add(pezUsuario);
                        break;
                    default:
                        break;
                }
                confirmacion.setVisible(true);
            }
        });
        UI.panel3.add(b1, BorderLayout.NORTH);
        this.b2 = new JButton("Ver listas → ");
        this.b2.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                new UI2();
                view.setContentPane(UI2.getJPanel());
                view.validate();
                view.invalidate();
            }
        });
        UI.panel3.add(b2, BorderLayout.CENTER);
        cns.gridx = 1; cns.gridy = 1; cns.gridwidth = 1; cns.gridheight = 1; cns.weightx = 1.0; cns.weighty = 1.0; cns.fill = GridBagConstraints.BOTH;
        UI.panelGod.add(panel3, cns);
    }
    //Getters
    public static JPanel getJPanel(){
        return panelGod;
    }
    public static String getListaMamiferos(){
        return mamiferos.toString();
    }
    public static String getListaAnfibios(){
        return anfibios.toString();
    }
    public static String getListaPeces(){
        return peces.toString();
    }
    public static String getListaReptiles(){
        return reptiles.toString();
    }
    public static String getListaAves(){
        return aves.toString();
    }
}