package eventos;

import java.awt.event.*;

import javax.swing.*;

import java.io.*;
import java.net.*;

public class ClientSendEvent implements ActionListener {

	private JTextField textField;
	private JTextArea chat;

    public  ClientSendEvent(JTextField textField, JTextArea chat) {
        this.textField = textField;
        this.chat = chat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String datos;
        if (textField.getText().equals("")) {
            // Vacio para no hacer nada si el usuario no ha ingresado nada
        } 
        if (!textField.getText().equals("")){
            try (
                Socket socket = new Socket("localhost", 3000);
                DataOutputStream envioStream = new DataOutputStream(socket.getOutputStream());
                ) {

                DataInputStream recibirStream = null;

                // Enviar el comando
                envioStream.writeUTF(textField.getText());

                // Recibir lo que manda el servidor
                recibirStream = new DataInputStream(socket.getInputStream());
                chat.append("Cliente: " + textField.getText());
                datos = recibirStream.readUTF();
                if (datos.equals("/cls")) {
                    chat.setText("");
                }
                if (datos.equals("/close")) {
                    this.chat.append("\t~Conexion Cerrada!~\n");
                } 
                else {
                    chat.append("\nServidor:\n" + datos);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                textField.setText(null);
            }
        }
    }
}