package clases;

import zoo.*;

public class Pez extends Animal {

    public Pez() {
        super();
    }

    public Pez(String n, String e, String a, int t) {
        super(n, e, a, t);
    }

    @Override
    public String toString() {
        return "\tTipo: Pez" + super.toString() + "\tComportamiento: " + getComportamiento();
    }

    @Override
    public String mostrar() {
        return ("Nombre: " + getNombre() + "\tEspecie: " + getEspecie() + "\tSe encuentran: " + getTotal()
                + "\tAlimentacion: " + getAlimentacion());
    }
}