package zoo;

import java.sql.*;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class DB {

    // DataBase Things
    private static DB db = new DB();
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private String driverDB = "org.postgresql.Driver";
    private String dbName = "zoo";
    private String urlDB = "jdbc:postgresql://localhost:5432/" + this.dbName;
    private String userDB = "postgres";
    private String passDB = "123";

    private JLabel confirmacion;
    private DefaultTableModel modelo;

    public DB() {
        try {
            Class.forName(driverDB);
            this.conn = DriverManager.getConnection(urlDB, userDB, passDB);
        } catch (ClassNotFoundException | SQLException event) {
            event.printStackTrace();
        }
    }

    public static DB getInstances() {
        return db;
    }

    // dbStatement que muestra los datos
    public ResultSet dbStatement(String query) {
        try {
            this.stmt = conn.createStatement();
            this.rs = stmt.executeQuery(query);
            while (rs.next()) {
                modelo.addRow(new Object[] { rs.getString("nombre"), rs.getString("especie"),
                        rs.getString("alimentacion"), rs.getInt("total"), rs.getString("comportamiento") });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.stmt.close();
                this.rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    // Borrar
    public void dbPrepareStmtDel(String query, Object[] obj) {
        try {
            this.pstmt = this.conn.prepareStatement(query);
            this.pstmt.setObject(1, obj[0].toString());
            this.pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Modificar
    public void dbPrepareStmtMod(String query, Object[] obj) {
        try {
            this.pstmt = this.conn.prepareStatement(query);
            this.pstmt.setString(1, (String) obj[0]);
            this.pstmt.setString(2, (String) obj[2]);
            this.pstmt.setInt(3, (int) obj[3]);
            this.pstmt.setString(4, (String) obj[4]);
            this.pstmt.setString(5, (String) obj[1]);
            this.pstmt.executeUpdate();
        } catch (SQLException event) {
            confirmacion.setText("Error: ya existe esa especie");
            confirmacion.setForeground(Color.red);
            confirmacion.setVisible(true);
            event.printStackTrace();
        } finally {
            try {
                this.pstmt.close();
            } catch (SQLException event) {
                event.printStackTrace();
            }
        }
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
            this.confirmacion.setText("Insertado!");
            this.confirmacion.setForeground(Color.orange);
            this.confirmacion.setVisible(true);
        } catch (SQLException event) {
            confirmacion.setText("Error: ya existe esa especie");
            confirmacion.setForeground(Color.red);
            confirmacion.setVisible(true);
            event.printStackTrace();
        } finally {
            try {
                this.pstmt.close();
            } catch (SQLException event) {
                event.printStackTrace();
            }
        }
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public void setConfirmacion(JLabel confirmacion) {
        this.confirmacion = confirmacion;
    }
}
