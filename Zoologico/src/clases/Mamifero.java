package clases;

import zoo.*;

public class Mamifero extends Animal {
    // constructores
    public Mamifero() {
        super();
    }

    public Mamifero(String n, String e, String a, int t) {
        super(n, e, a, t);
    }

    @Override
    public String toString() {
        return "\tTipo: Mamifero" + super.toString() + "\tComportamiento: " + super.getComportamiento();
    }

    @Override
    public String mostrar() {
        return ("Nombre: " + getNombre() + "\tEspecie: " + getEspecie() + "\tSe encuentran: " + getTotal()
                + "\tAlimentacion: " + getAlimentacion());
    }
}