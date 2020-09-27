package UI;

import java.awt.*;
import java.awt.event.*;

import zoo.DB;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

import java.sql.*;

public class UI3 {

    private String[] columnas = { "Nombre", "Especie", "Alimentacion", "Total", "Comportamiento" };
    private String[] tablaSql = { "mamiferos", "reptiles", "aves", "anfibios", "peces" };
    private DefaultTableModel modelo = new DefaultTableModel();
    private JPanel panelMostrar, panelBot;
    private JButton volver, borrar;
    private JTable tabla;
    private Object llavePrimaria;
    private int fila;

    public UI3(int key, JFrame ventana) {
        // Añadir las columnas
        this.tabla = new JTable(modelo);
        for (int i = 0; i < columnas.length; i++) {
            modelo.addColumn(columnas[i]);
        }
        DB.getInstances().setModelo(modelo);
        // Hacer el query correspondiente
        this.panelMostrar = new JPanel(new BorderLayout());
        this.panelBot = new JPanel(new GridLayout(1, 2));
        switch (key) {
            case 1:
                DB.getInstances().dbStatement("select * from " + tablaSql[key - 1]);
                break;
            case 2:
                DB.getInstances().dbStatement("select * from " + tablaSql[key - 1]);
                break;
            case 3:
                DB.getInstances().dbStatement("select * from " + tablaSql[key - 1]);
                break;
            case 4:
                DB.getInstances().dbStatement("select * from " + tablaSql[key - 1]);
                break;
            case 5:
                DB.getInstances().dbStatement("select * from " + tablaSql[key - 1]);
                break;
            default:
        }
        this.tabla.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tabla);
        this.panelMostrar.add(scrollPane, BorderLayout.CENTER);
        borrar = new JButton("Borrar");
        // Capturar accion del Usuario en la tabla
        this.tabla.addMouseListener(new MouseInputAdapter() {

            public void mouseClicked(MouseEvent m) {
                fila = tabla.rowAtPoint(m.getPoint());
                llavePrimaria = tabla.getValueAt(fila, 1);
                Object[] prueba = { String.valueOf(llavePrimaria) };
                borrar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        DB.getInstances().dbPrepareStmtDel("delete from " + tablaSql[key - 1] + " where especie = ?", prueba);
                        UI3 prueba = new UI3(key, ventana);
                        ventana.setContentPane(prueba.getJPanel());
                        ventana.validate();
                        ventana.invalidate();
                    }
                });
            }
        });
        // Actualizar Datos
        tabla.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                int fila = e.getFirstRow();
                TableModel model = (TableModel) e.getSource();
                Object[] data = { model.getValueAt(fila, 0), model.getValueAt(fila, 1), model.getValueAt(fila, 2), Integer.parseInt(model.getValueAt(fila, 3).toString()), model.getValueAt(fila, 4) };
                DB.getInstances().dbPrepareStmtMod("update " + tablaSql[key - 1] + " set nombre = ?, alimentacion = ?, total = ?, comportamiento = ? where especie = ?", data);
            }
        });

        // Boton Volver
        this.volver = new JButton("Volver");
        this.volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI2 ui2 = new UI2(ventana);
                ventana.setContentPane(ui2.getJPanel());
                ventana.validate();
                ventana.invalidate();
            }

        });

        this.panelBot.add(volver, BorderLayout.SOUTH);
        this.panelBot.add(borrar, BorderLayout.SOUTH);
        this.panelMostrar.add(panelBot, BorderLayout.SOUTH);

    }

    public JPanel getJPanel() {
        return this.panelMostrar;
    }

}