package cliente;

import javax.swing.*;

public class ClientFrame {

    private JFrame frame;

    public ClientFrame() {

        this.frame = new JFrame("Zoo AppCliente");

        new ClientApp(frame);

        this.frame.setBounds(150, 100, 550, 500);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
