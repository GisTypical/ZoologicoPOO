package cliente;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Hilo implements Runnable {

    private Socket socket = null;
    private DataInputStream recibirStream = null;
    private DataOutputStream enviarStream = null;
    private ServerSocket serverSocket = null;
    private ArrayList<String> tablas;
    private int cont, i;
    private String union = "", datos;
    public static Thread hilo;

    public Hilo(){
        
        this.hilo = new Thread(this);

        this.hilo.start();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(3000);
            // While para que mantenga la conexion
            while (true) {
                socket = serverSocket.accept();
                recibirStream = new DataInputStream(socket.getInputStream());
                datos = recibirStream.readUTF();
                String[] partes = datos.split(" ");
                cont = 0;
                switch (partes[0]) {
                    case "/mostrar":
                        // Mostrar Todo
                        if (partes[1].equals("todo")) {
                            cont = 0;
                            i = 0;
                            tablas = new ArrayList<>();
                            // Obtener las tablas
                            DBCliente.getInstances().dbStatementTablas(
                                    "SELECT table_name FROM information_schema.tables WHERE table_schema='public' AND table_type='BASE TABLE'");
                            for (int j = 0; j < tablas.size(); j++) {
                                // Mostrar todo con las tablas obtenidas
                                DBCliente.getInstances().dbStatementTodo("select * from " + tablas.get(j));
                            }
                        } else {
                            // Sino no es mostrar Todo, solo se muestra lo que se necesita
                            DBCliente.getInstances().dbStatementCliente("select * from " + partes[1]);
                        }
                        break;
                    case "/buscarE": // Buscar por Especie
                        union = "";
                        for (int i = 2; i < partes.length; i++) {
                            union += partes[i] + " ";
                        }
                        if ((union.length() <= 0) || (union == null)) {
                            datos = "Pocos argumentos\n";
                            break;
                        }
                        DBCliente.getInstances().dbStatementCliente("select * from " + partes[1] + " where especie = '"
                                + union.substring(0, union.length() - 1) + "'");
                        break;
                    case "/buscarN": // Buscar por Nombre
                        union = "";
                        for (int i = 2; i < partes.length; i++) {
                            union += partes[i] + " ";
                        }
                        if ((union.length() <= 0) || (union == null)) {
                            datos = "Pocos argumentos\n";
                            break;
                        }
                        DBCliente.getInstances().dbStatementCliente("select * from " + partes[1] + " where nombre = '"
                                + union.substring(0, union.length() - 1) + "'");
                        break;
                    case "/buscarA": // Buscar por Alimentacion
                        union = "";
                        for (int i = 2; i < partes.length; i++) {
                            union += partes[i] + " ";
                        }
                        if ((union.length() <= 0) || (union == null)) {
                            datos = "Pocos argumentos\n";
                            break;
                        }
                        DBCliente.getInstances().dbStatementCliente("select * from " + partes[1] + " where alimentacion = '"
                                + union.substring(0, union.length() - 1) + "'");
                        break;
                    case "/cls": // Limpiar el JTextArea
                        break;
                    default: // Comando Incorrecto
                        datos = "Comando '" + partes[0] + "' es invalido\n";
                        break;
                }
                if (datos.equals("")) {
                    // Si la base de datos no retorna info
                    datos = "No existe informacion.\n";
                }
                // EnviarResultado del Query
                enviarStream = new DataOutputStream(socket.getOutputStream());
                enviarStream.writeUTF(datos);
                enviarStream.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
