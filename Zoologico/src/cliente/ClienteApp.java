package cliente;

import javax.swing.*;

import eventos.ClientSendEvent;

import java.awt.*;
import java.awt.event.*;

public class ClienteApp extends JPanel {

    private static final long serialVersionUID = 1L;
    // Componentes Swing
    private JTextArea chat;
    private JTextField textField;
    private JButton enviar;
    private GridBagConstraints cns;

    public ClienteApp(JFrame frame) {

        this.cns = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.chat = new JTextArea();
        this.gridBagConstraints(0, 0, 3, 2, 1.0, 1.0, GridBagConstraints.BOTH);
        this.chat.setEditable(false);
        this.add(new JScrollPane(this.chat), this.cns);
        this.textField = new JTextField();
        this.gridBagConstraints(0, 2, 2, 3, 1.0, 0.0, GridBagConstraints.BOTH);
        this.add(this.textField, this.cns);
        this.textField.addActionListener(new ClientSendEvent(this.textField, this.chat));

        this.enviar = new JButton("Comandos");
        this.gridBagConstraints(2, 2, 1, 3, 0.0, 0.0, GridBagConstraints.BOTH);
        this.cns.fill = GridBagConstraints.BOTH;
        this.enviar.addActionListener((ActionEvent e) -> {
            new JOptionPane();
            JOptionPane.showMessageDialog(frame, optionPaneMsg(), "Ayuda", JOptionPane.INFORMATION_MESSAGE);
        });
        this.add(this.enviar, this.cns);
        frame.add(this);
    }

    private void gridBagConstraints(int cns1, int cns2, int cns3, int cns4, double cns5, double cns6, int cns7) {
        this.cns.gridx = cns1;
        this.cns.gridy = cns2;
        this.cns.gridwidth = cns3;
        this.cns.gridheight = cns4;
        this.cns.weightx = cns5;
        this.cns.weighty = cns6;
        this.cns.fill = cns7;
    }

    private String optionPaneMsg() {
        StringBuilder msg = new StringBuilder();
        msg.append("Comandos permitidos:\n");
        msg.append("/mostrar 'tabla': muestra datos de una tabla o tipo de animal\n");
        msg.append("/mostrar todo: muestra todos los animales de todas las tablas o tipos\n");
        msg.append("/buscarE 'tabla' 'especie': busca un animal en una tabla por su especie\n");
        msg.append("/buscarN 'tabla' 'nombre': buscar animales en una tabla por su nombre\n");
        msg.append("/buscarA 'tabla' 'alimentacion': buscar animales en una tabla por su alimentacion\n");
        msg.append("/cls: limpiar el area de texto\n");
        msg.append("/close: cierra el socket\n");
        msg.append("Tenga cuidado al buscar, es case sensitive\n");
        return msg.toString();
    }
}