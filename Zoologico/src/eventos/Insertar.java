package eventos;

import java.awt.event.*;
import javax.swing.JTextField;
import zoo.*;

public class Insertar implements ActionListener {

    private JTextField textFieldN;
    private JTextField textFieldE;
    private JTextField textFieldA;
    private JTextField textFieldT;
    private JTextField textFieldC;
    private int key;

    public Insertar(JTextField nField, JTextField eField, JTextField aField, JTextField tField, JTextField cField) {
        this.textFieldN = nField;
        this.textFieldE = eField;
        this.textFieldA = aField;
        this.textFieldT = tField;
        this.textFieldC = cField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = textFieldN.getText();
        String especie = textFieldE.getText();
        String alimentacion = textFieldA.getText();
        int totalInt = Integer.parseInt(textFieldT.getText());
        String comportamiento = textFieldC.getText();
        Object[] obj = { nombre, especie, alimentacion, totalInt, comportamiento };
        String[] animal = { "mamiferos", "reptiles", "aves", "anfibios", "peces" };
        DB.getInstances().dbPrepareStmtAdd("insert into " + animal[key - 1] + " values (?,?,?,?,?)", obj);
    }

    public void setkey(int key) {
        this.key = key;
    }

}
