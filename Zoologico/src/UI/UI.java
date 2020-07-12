package UI;

//imports
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UI {
    //Parametros de Conexion a base de datos
    private Connection conn;
    private PreparedStatement pstmt;
    private String driverDB = "org.postgresql.Driver";
    private String dbName = "zoo";
    private String urlDB = "jdbc:postgresql://localhost:5432/" + this.dbName;
    private String userDB = "postgres";
    private String passDB = "123";

    public static JFrame view;
    private static JPanel panelGod, panel1, panel2, panel3;
    private Border border;
    private JTextField textFieldN, textFieldE, textFieldA, textFieldC, textFieldT;
    public static JLabel confirmacion;
    private JButton b1;
	private JButton b2;
    private GridBagConstraints cns = new GridBagConstraints();
    private int key = 1;
    
    public UI(){
        DB();
        border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        UI.view = new JFrame("Zoologico OS v2");
        UI.panelGod = new JPanel();
        UI.panelGod.setLayout(new GridBagLayout());
        Paneles();
        UI.view.add(panelGod); 

        UI.view.setBounds(500, 250, 500, 275);
        UI.view.setVisible(true);
        UI.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UI.view.setResizable(false);
    }

    public void Paneles(){

        //PANEL 1

        UI.panel1 = new JPanel();
        UI.panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        TitledBorder titleBorderL = BorderFactory.createTitledBorder(border,"(Datos Animal)");
        titleBorderL.setTitleJustification(TitledBorder.CENTER);
        UI.panel1.setBorder(titleBorderL);
        
        //Instanciar los Labels y los TextFields
        UI.panel1.add(new JLabel("Nombre:")); this.textFieldN = new JTextField(); UI.panel1.add(textFieldN);
        UI.panel1.add(new JLabel("Especie:")); this.textFieldE = new JTextField(); UI.panel1.add(textFieldE); 
        UI.panel1.add(new JLabel("Total de animales:")); this.textFieldT = new JTextField(); UI.panel1.add(textFieldT);
        UI.panel1.add(new JLabel("Alimentacion:")); this.textFieldA = new JTextField(); UI.panel1.add(textFieldA); 
        UI.panel1.add(new JLabel("Comportamiento:")); this.textFieldC = new JTextField(); UI.panel1.add(textFieldC);
        cns.gridx = 0; cns.gridy = 0; cns.gridwidth = 1; cns.gridheight = 2; cns.weightx = 1.0; cns.weighty = 1.0; cns.fill = GridBagConstraints.BOTH;
        UI.panelGod.add(panel1, cns);
        
        //PANEL 2

        UI.panel2 = new JPanel();
        UI.panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
        TitledBorder titleBorderUR = BorderFactory.createTitledBorder(border,"(Tipo Animal)");
        titleBorderUR.setTitleJustification(TitledBorder.CENTER);
        UI.panel2.setBorder(titleBorderUR);
        ButtonGroup group = new ButtonGroup();
        //Instanciar los JRadioButton
        JRadioButton radioMamifero = new JRadioButton("Mamifero", true);
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
			public void actionPerformed(ActionEvent event) {
				key = 1;
            }
        });
        radioReptil.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				key = 2;
            }
        });
        radioAve.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				key = 3;
            }
        });
        radioAnfibio.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				key = 4;
            }
        });
        radioPez.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				key = 5;
            }
        });
        UI.confirmacion = new JLabel();
        UI.confirmacion.setVisible(false);
        UI.panel2.add(UI.confirmacion);
        cns.gridx = 1; cns.gridy = 0; cns.gridwidth = 1; cns.gridheight = 1; cns.weightx = 1.0; cns.weighty = 1.0; cns.fill = GridBagConstraints.BOTH;
        UI.panelGod.add(panel2, cns);

        //PANEL 3

        UI.panel3 = new JPanel();
        UI.panel3.setLayout(new BorderLayout());
        this.b1 = new JButton("Insertar animal");
        this.b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                String nombre = textFieldN.getText();
                String especie = textFieldE.getText();
                String alimentacion = textFieldA.getText();
                int totalInt = Integer.parseInt(textFieldT.getText());
                String comportamiento = textFieldC.getText();
                Object[] obj = {nombre, especie, alimentacion, totalInt, comportamiento};
                switch (key) {
                    case 1:
                        dbPrepareStmtAdd("insert into mamiferos values (?,?,?,?,?)", obj);
                        break;
                    case 2:
                        dbPrepareStmtAdd("insert into reptiles values (?,?,?,?,?)", obj);
                        break;
                    case 3:
                        dbPrepareStmtAdd("insert into aves values (?,?,?,?,?)", obj);
                        break;
                    case 4:
                        dbPrepareStmtAdd("insert into anfibios values (?,?,?,?,?)", obj);
                        break;
                    case 5:
                        dbPrepareStmtAdd("insert into mamiferos values (?,?,?,?,?)", obj);
                        break;
                    }
            }
        });
        UI.panel3.add(b1, BorderLayout.NORTH);
        this.b2 = new JButton("Ver listas ->");
        this.b2.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent event){
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

    public void DB() { 
        try {
            Class.forName(driverDB);
            this.conn = DriverManager.getConnection(urlDB, userDB, passDB);
            System.out.println("Conexion establecida");
        } catch (ClassNotFoundException | SQLException event) {
            event.printStackTrace();
        }
    }
    //Getters
    public static JPanel getJPanel(){
        return panelGod;
    }

    public void dbPrepareStmtAdd(String query, Object[] obj) {
        try {
            this.pstmt = this.conn.prepareStatement(query);
            this.pstmt.setString(1, (String) obj[0]);
            this.pstmt.setString(2, (String) obj[1]);
            this.pstmt.setString(3, (String) obj[2]);
            this.pstmt.setInt(4, (int) obj[3]);
            this.pstmt.setString(5, (String) obj[4]);
            this.pstmt.executeUpdate();
            UI.confirmacion.setText("Insertado!");
            UI.confirmacion.setForeground(Color.orange);
            UI.confirmacion.setVisible(true);
            this.textFieldN.setText(null);
            this.textFieldE.setText(null);
            this.textFieldT.setText(null);
            this.textFieldA.setText(null);
            this.textFieldC.setText(null);
        } 
        catch (SQLException event) {
            UI.confirmacion.setText("Error: ya existe esa especie");
            UI.confirmacion.setForeground(Color.red);
            UI.confirmacion.setVisible(true);
            event.printStackTrace();
        } 
        finally {
            try {
                this.pstmt.close();
            } 
            catch (SQLException event) {
                event.printStackTrace();
            }
        }
    }
}