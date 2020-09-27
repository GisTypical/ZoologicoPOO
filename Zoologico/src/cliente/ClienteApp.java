package cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ClienteApp {
    // Sockets
    private Socket socket = null;
    private DataOutputStream envioStream = null;
    private DataInputStream recibirStream = null;
    private String datos;
    // Componentes Swing
    private JFrame frame;
    private JPanel panelGod;
    private JTextArea chat;
    private JTextField textField;
    private JButton enviar;
    private JScrollPane scroll;
    private GridBagConstraints cns;

    public ClienteApp() {

        this.cns = new GridBagConstraints();
        this.frame = new JFrame("Zoo AppCliente");
        this.panelGod = new JPanel(new GridBagLayout());
        this.chat = new JTextArea();
        cns.gridx = 0;
        cns.gridy = 0;
        cns.gridwidth = 3;
        cns.gridheight = 2;
        cns.weightx = 1.0;
        cns.weighty = 1.0;
        cns.fill = GridBagConstraints.BOTH;
        this.chat.setEditable(false);
        this.scroll = new JScrollPane(chat);
        this.panelGod.add(scroll, cns);
        this.textField = new JTextField();
        cns.gridx = 0;
        cns.gridy = 2;
        cns.gridwidth = 2;
        cns.gridheight = 3;
        cns.weightx = 1.0;
        cns.weighty = 0.0;
        cns.fill = GridBagConstraints.BOTH;
        this.panelGod.add(textField, cns);
        this.textField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Evento();
            }

        });

        this.enviar = new JButton("Ayuda");
        cns.gridx = 2;
        cns.gridy = 2;
        cns.gridwidth = 1;
        cns.gridheight = 3;
        cns.weightx = 0.0;
        cns.weighty = 0.0;
        cns.fill = GridBagConstraints.BOTH;
        this.enviar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new JOptionPane();
                JOptionPane.showMessageDialog(frame,
                        "Comandos permitidos:\n/mostrar 'tabla': muestra datos de una tabla o tipo de animal\n/mostrar todo: muestra todos los animales de todas las tablas o tipos\n/buscarE 'tabla' 'especie': busca un animal en una tabla por su especie\n/buscarN 'tabla' 'nombre': buscar animales en una tabla por su nombre\n/buscarA 'tabla' 'alimentacion': buscar animales en una tabla por su alimentacion\n/cls: limpiar el area de texto\nTenga cuidado al buscar, es case sensitive\n",
                        "Ayuda", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.panelGod.add(enviar, cns);

        this.frame.add(panelGod);
        this.frame.setBounds(150, 100, 550, 500);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void Evento() {
        if (textField.getText().equals("")) {
        } else {
            try {
                
                // Enviar el comando
                socket = new Socket("localhost", 3000);
                envioStream = new DataOutputStream(socket.getOutputStream());
                envioStream.writeUTF(textField.getText());

                // Recibir lo que manda el servidor
                recibirStream = new DataInputStream(socket.getInputStream());
                chat.append("Cliente: " + textField.getText());
                datos = recibirStream.readUTF();
                if (datos.equals("/cls")) {
                    chat.setText("");
                } else {
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