package UI.ui1;

import javax.swing.*;
import javax.swing.border.*;

public class LeftPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static LeftPanel lp = new LeftPanel();

    private JTextField textFieldN;
    private JTextField textFieldE;
    private JTextField textFieldA;
    private JTextField textFieldC;
    private JTextField textFieldT;
    private Border border;

    public LeftPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titleBorderL = BorderFactory.createTitledBorder(border, "(Datos Animal)");
        titleBorderL.setTitleJustification(TitledBorder.CENTER);
        this.setBorder(titleBorderL);

        //Labels
        this.add(new JLabel("Nombre:"));
        this.textFieldN = new JTextField();
        this.add(textFieldN);
        this.add(new JLabel("Especie:"));
        this.textFieldE = new JTextField();
        this.add(textFieldE);
        this.add(new JLabel("Total de animales:"));
        this.textFieldT = new JTextField();
        this.add(textFieldT);
        this.add(new JLabel("Alimentacion:"));
        this.textFieldA = new JTextField();
        this.add(textFieldA);
        this.add(new JLabel("Comportamiento:"));
        this.textFieldC = new JTextField();
        this.add(textFieldC);

    }

    public JTextField getTFN() {
        return textFieldN;
    }

    public JTextField getTFE() {
        return textFieldE;
    }

    public JTextField getTFA() {
        return textFieldA;
    }

    public JTextField getTFC() {
        return textFieldC;
    }

    public JTextField getTFT() {
        return textFieldT;
    }
}
