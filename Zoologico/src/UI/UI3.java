package UI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

import java.sql.*;

public class UI3 {

    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rs;
    private String driverDB = "org.postgresql.Driver";
    private String dbName = "zoo";
    private String urlDB = "jdbc:postgresql://localhost:5432/" + this.dbName;
    private String userDB = "postgres";
    private String passDB = "123";

    private String[] columnas = { "Nombre", "Especie", "Alimentacion", "Total", "Comportamiento" };
    private String[] tablaSql = { "mamiferos", "reptiles", "aves", "anfibios", "peces" };
    private DefaultTableModel modelo = new DefaultTableModel();
    private JPanel panelMostrar, panelBot;
    private JButton volver, borrar;
    private JTable tabla;
    private Object llavePrimaria;
    private int fila;

    public UI3(int key) {
        DB();
        // Añadir las columnas
        this.tabla = new JTable(modelo);
        for (int i = 0; i < columnas.length; i++) {
            modelo.addColumn(columnas[i]);
        }
        // Hacer el query correspondiente
        this.panelMostrar = new JPanel(new BorderLayout());
        this.panelBot = new JPanel(new GridLayout(1, 2));
        switch (key) {
            case 1:
                dbStatement("select * from " + tablaSql[key - 1]);
                break;
            case 2:
                dbStatement("select * from " + tablaSql[key - 1]);
                break;
            case 3:
                dbStatement("select * from " + tablaSql[key - 1]);
                break;
            case 4:
                dbStatement("select * from " + tablaSql[key - 1]);
                break;
            case 5:
                dbStatement("select * from " + tablaSql[key - 1]);
                break;
        }
        this.tabla.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tabla);
        this.panelMostrar.add(scrollPane, BorderLayout.CENTER);
        borrar = new JButton("Borrar");
        //Capturar accion del Usuario en la tabla
        this.tabla.addMouseListener(new MouseInputAdapter() {

            public void mouseClicked(MouseEvent m) {
                fila = tabla.rowAtPoint(m.getPoint());
                llavePrimaria = tabla.getValueAt(fila, 1);
                Object prueba[] = { String.valueOf(llavePrimaria) };
                borrar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dbPrepareStmtDel("delete from " + tablaSql[key - 1] + " where especie = ?", prueba);
                        UI3 prueba = new UI3(key);
                        UI.view.setContentPane(prueba.getJPanel());
                        UI.view.validate();
                        UI.view.invalidate();
                    }
                });
            }
        });
        //Actualizar Datos
        tabla.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                int fila = e.getFirstRow();
                TableModel model = (TableModel)e.getSource();
                Object[] data = {model.getValueAt(fila, 0), model.getValueAt(fila, 1), model.getValueAt(fila, 2), Integer.parseInt(model.getValueAt(fila, 3).toString()), model.getValueAt(fila, 4)};
                dbPrepareStmtMod("update " + tablaSql[key - 1] + " set nombre = ?, alimentacion = ?, total = ?, comportamiento = ? where especie = ?", data);
            }
        });

        //Boton Volver
        this.volver = new JButton("Volver");
        this.volver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                UI.view.setContentPane(UI2.getJPanel());
                UI.view.validate();
                UI.view.invalidate();
            }

        });

        this.panelBot.add(volver, BorderLayout.SOUTH);
        this.panelBot.add(borrar, BorderLayout.SOUTH);
        this.panelMostrar.add(panelBot, BorderLayout.SOUTH);
        
    }

    public JPanel getJPanel(){
        return this.panelMostrar;
    }
    //dbStatement que muestra los datos
    public ResultSet dbStatement(String query) {
        try {
            this.stmt = conn.createStatement();
            this.rs = stmt.executeQuery(query);
            while (rs.next()) {
                modelo.addRow(new Object[] {rs.getString("nombre"), rs.getString("especie"), rs.getString("alimentacion"), rs.getInt("total"), rs.getString("comportamiento")});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                this.stmt.close();
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }    
    //Borrar
    public void dbPrepareStmtDel(String query, Object[] obj) {
        try {
            this.pstmt = this.conn.prepareStatement(query);
            this.pstmt.setObject(1, (String) obj[0]);
            this.pstmt.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
            try {
                this.pstmt.close();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //instanciar DB
    public void DB() { 
        try {
            Class.forName(driverDB);
            this.conn = DriverManager.getConnection(urlDB, userDB, passDB);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    //Modificar
    public void dbPrepareStmtMod(String query, Object[] obj) {
        try {
            this.pstmt = this.conn.prepareStatement(query);
            this.pstmt.setString(1, (String) obj[0]);
            this.pstmt.setString(2, (String) obj[2]);
            this.pstmt.setInt(3, (int) obj[3]);
            this.pstmt.setString(4, (String) obj[4]);
            this.pstmt.setString(5, (String) obj[1]);
            this.pstmt.executeUpdate();
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