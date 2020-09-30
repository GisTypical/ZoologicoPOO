package ui;

import cliente.*;
import java.io.*;
import java.util.logging.*;
import java.net.*;
import java.util.ArrayList;

public class Hilo implements Runnable {

    private String datos;
    private String[] partes;
    private Logger logger = Logger.getLogger("Log"); 

    public Hilo() {

        Thread thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {
        String union = "";
        DataOutputStream enviarStream = null;
        // Try-with-resources
        try (ServerSocket serverSocket = new ServerSocket(3000);) {
            // While para que mantenga la conexion
            while (this.validar) {
                Socket socket = serverSocket.accept();
                DataInputStream recibirStream = new DataInputStream(socket.getInputStream());
                this.datos = recibirStream.readUTF();
                DBCliente.getInstances().setDatos(this.datos);
                this.partes = this.datos.split(" ");
                switch (this.partes[0]) {
                    case "/mostrar":
                        this.mostrar();
                        break;
                    case "/buscarE": // Buscar por Especie
                        this.indexSpc = this.datos.indexOf(" ", 9);
                        union = this.datos.substring(this.indexSpc + 1);
                        if (this.indexSpc == -1) {
                            this.datos = POCOSARGUMENTOS;
                            break;
                        }
                        this.datos = DBCliente.getInstances()
                                .dbStatementCliente(SELECT + this.partes[1] + " where especie = '" + union + "'");
                        break;
                    case "/buscarN": // Buscar por Nombre
                        union = this.datos.substring(this.datos.indexOf(" ", 9) + 1);
                        if (this.indexSpc == -1) {
                            this.datos = POCOSARGUMENTOS;
                            break;
                        }
                        this.datos = DBCliente.getInstances()
                                .dbStatementCliente(SELECT + this.partes[1] + " where nombre = '" + union + "'");
                        break;
                    case "/buscarA": // Buscar por Alimentacion
                        union = this.datos.substring(this.datos.indexOf(" ", 9) + 1);
                        if (this.indexSpc == -1) {
                            this.datos = POCOSARGUMENTOS;
                            break;
                        }
                        this.datos = DBCliente.getInstances()
                                .dbStatementCliente(SELECT + this.partes[1] + " where alimentacion = '" + union + "'");
                        break;
                    case "/cls": // Limpiar el JTextArea
                        break;
                    case "/close":
                        break;
                    default: // Comando Incorrecto
                        this.datos = "\t~Comando '" + this.partes[0] + "' es invalido~\n";
                        break;
                }
                if (datos.equals("")) {
                    // Si la base de datos no retorna info
                    this.datos = "\t~No existe informacion~\n";
                }
                // EnviarResultado del Query
                enviarStream = new DataOutputStream(socket.getOutputStream());
                enviarStream.writeUTF(this.datos);
                enviarStream.close();
                socket.close();
            }
        } catch (IOException e) {
            logger.log(Level.FINE, "Servidor continua en segundo plano.");
        }
    }

    private void mostrar() {
        if (this.partes[1].equals("todo")) {
            // Mostrar tablas
            ArrayList<String> tablas = new ArrayList<>();
            DBCliente.getInstances().setTabla(tablas);
            // Obtener las tablas para clasificar los resultados
            DBCliente.getInstances().dbStatementTablas(QUERYTABLAS);
            DBCliente.getInstances().setNumTabla(0);
            DBCliente.getInstances().clsDatos();
            for (int j = 0; j < tablas.size(); j++) {
                // Mostrar todo con las tablas obtenidas
                this.datos = DBCliente.getInstances().dbStatementTodo(SELECT + tablas.get(j));
            }
        } else {
            // Sino no es mostrar Todo, solo se muestra lo que se necesita
            this.datos = DBCliente.getInstances().dbStatementCliente(SELECT + this.partes[1]);
        }
    }

    public String getDatos() {
        return this.datos;
    }

    private boolean validar = this.datos == null || !this.datos.equals("/close");
    private int indexSpc;
    private static final String SELECT = "SELECT * FROM ";
    private static final String POCOSARGUMENTOS = "\t~Pocos argumentos~\n";
    private static final String QUERYTABLAS = "SELECT table_name FROM information_schema.tables WHERE table_schema='public' AND table_type='BASE TABLE'";

}