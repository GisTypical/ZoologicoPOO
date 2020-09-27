package cliente;

import UI.*;
import UI.ui1.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;
import java.awt.*;

public class DBCliente {

    private static DBCliente db = new DBCliente();
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private String driverDB = "org.postgresql.Driver";
    private String dbName = "zoo";
    private String urlDB = "jdbc:postgresql://localhost:5432/" + this.dbName;
    private String userDB = "postgres";
    private String passDB = "123";
    private ArrayList<String> tablas;
    private int cont, i;
    private String union = "", datos;


    public DBCliente() {
        try {
            Class.forName(driverDB);
            this.conn = DriverManager.getConnection(urlDB, userDB, passDB);
        } catch (ClassNotFoundException | SQLException event) {
            event.printStackTrace();
        }
    }

    public static DBCliente getInstances() {
        return db;
    }

    // Funcion para buscar y mostrar
    public ResultSet dbStatementCliente(String query) {
        try {
            this.stmt = conn.createStatement();
            this.rs = stmt.executeQuery(query);
            if (cont == 0) {
                datos = "";
                cont++;
            }
            while (rs.next()) {
                datos += "Nombre:\t" + rs.getString("nombre") + "\nEspecie:\t" + rs.getString("especie")
                        + "\nAlimentacion:\t" + rs.getString("alimentacion") + "\nTotal:\t" + rs.getInt("total")
                        + "\nComporta.:\t" + rs.getString("comportamiento") + "\n\n";
            }
            try {
                this.stmt.close();
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            String partes[] = datos.split(" ");
            datos = "Tipo de animal '" + partes[1] + "' es invalido\n";
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet dbStatementTodo(String query) {
        String partes[] = datos.split(" ");
        try {
            this.stmt = conn.createStatement();
            this.rs = stmt.executeQuery(query);
            if (cont == 0) {
                datos = "";
                cont++;
            }
            datos += "-------------------------------" + tablas.get(i).toUpperCase()
                    + "-------------------------------\n";
            while (rs.next()) {
                datos += "Nombre:\t" + rs.getString("nombre") + "\nEspecie:\t" + rs.getString("especie")
                        + "\nAlimentacion:\t" + rs.getString("alimentacion") + "\nTotal:\t" + rs.getInt("total")
                        + "\nComporta.:\t" + rs.getString("comportamiento") + "\n\n";
            }
            i++;
            try {
                this.stmt.close();
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            datos = "Tipo de animal '" + partes[1] + "' es invalido\n";
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet dbStatementTablas(String query) {
        String[] partes = datos.split(" ");
        try {
            this.stmt = conn.createStatement();
            this.rs = stmt.executeQuery(query);
            while (rs.next()) {
                tablas.add(rs.getString("table_name"));
            }
            try {
                this.stmt.close();
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            datos = "Tipo de animal '" + partes[1] + "' es invalido\n";
            e.printStackTrace();
        }
        return rs;
    }
}
