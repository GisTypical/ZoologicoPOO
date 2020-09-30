package cliente;

import java.sql.*;
import java.util.ArrayList;

public class DBCliente {

    // Postgre things
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
    private int numTabla;
    private String datos;
    private String[] partes;
    private StringBuilder sBDatos = new StringBuilder();

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
    public String dbStatementCliente(String query) {
        this.partes = datos.split(" ");
        try {
            this.stmt = conn.createStatement();
            this.rs = stmt.executeQuery(query);
            // Si el query no da fallos realiza lo siguiente
            if (!this.datos.equals("")) {
                this.datos = "";
                this.sBDatos.delete(0, this.sBDatos.length());
            }
            while (rs.next()) {
                this.sBDatos.append("Nombre:\t" + rs.getString("nombre"));
                this.sBDatos.append("\nEspecie:\t" + rs.getString("especie"));
                this.sBDatos.append("\nAlimentacion:\t" + rs.getString("alimentacion"));
                this.sBDatos.append("\nTotal:\t" + rs.getInt("total"));
                this.sBDatos.append("\nComporta.:\t" + rs.getString("comportamiento") + "\n\n");
            }
            this.datos = this.sBDatos.toString();
            this.closeConnection();
        } catch (SQLException e) {
            this.datos = TIPOINVALIDO.replace("_", partes[1]);
            e.printStackTrace();
        }
        return this.datos;
    }

    public String dbStatementTodo(String query) {
        this.partes = datos.split(" ");
        try {
            this.stmt = conn.createStatement();
            this.rs = stmt.executeQuery(query);
            // Si el query no da fallos realiza lo siguiente
            if (!this.datos.equals("")) {
                this.datos = "";
            }
            this.sBDatos.append("-------------------------------");
            this.sBDatos.append(tablas.get(this.numTabla).toUpperCase());
            this.sBDatos.append("-------------------------------\n");
            while (rs.next()) {
                this.sBDatos.append("Nombre:\t" + rs.getString("nombre"));
                this.sBDatos.append("\nEspecie:\t" + rs.getString("especie"));
                this.sBDatos.append("\nAlimentacion:\t" + rs.getString("alimentacion"));
                this.sBDatos.append("\nTotal:\t" + rs.getInt("total"));
                this.sBDatos.append("\nComporta.:\t" + rs.getString("comportamiento") + "\n\n");
            }
            this.datos = this.sBDatos.toString();
            this.numTabla++;
            this.closeConnection();
        } catch (SQLException e) {
            this.closeConnection();
            e.printStackTrace();
        }
        return this.datos;
    }

    public String dbStatementTablas(String query) {
        this.partes = datos.split(" ");
        try {
            this.stmt = conn.createStatement();
            this.rs = stmt.executeQuery(query);
            while (rs.next()) {
                tablas.add(rs.getString("table_name"));
            }
            this.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public void setTabla(ArrayList<String> tablas) {
        this.tablas = tablas;
    }

    public void clsDatos() {
        this.sBDatos.delete(0, this.sBDatos.length());
    }

    public void setNumTabla(int numTabla) {
        this.numTabla = numTabla;
    }

    private void closeConnection() {
        try {
            this.stmt.close();
            this.rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static final String TIPOINVALIDO = "\t~Tipo de animal '_' no existe~\n";
}
