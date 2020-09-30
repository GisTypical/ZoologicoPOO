package clases;

import zoo.*;

public class Anfibio extends Animal {

    public Anfibio() {
        super();
    }

    public Anfibio(String n, String e, String a, int t) {
        super(n, e, a, t);
    }

    @Override
    public String toString() {
        return "\tTipo: Anfibio" + super.toString() + "\tComportamiento: " + super.getComportamiento();
    }

    @Override
    public String mostrar() {
        return ("Nombre: " + getNombre() + "\tEspecie: " + getEspecie() + "\tSe encuentran: " + getTotal()
                + "\tAlimentacion: " + getAlimentacion());
    }
}