package clases;

import zoo.*;

public class Ave extends Animal {
    // Constructores
    public Ave() {
        super();
    }

    public Ave(String n, String e, String a, int t) {
        super(n, e, a, t);
    }

    @Override
    public String toString() {
        return "\tTipo: Ave" + super.toString() + "\tComportamiento: " + super.getComportamiento();
    }

    @Override
    public String mostrar() {
        return ("Nombre: " + getNombre() + "\tEspecie: " + getEspecie() + "\tSe encuentran: " + getTotal()
                + "\tAlimentacion: " + getAlimentacion());
    }
}