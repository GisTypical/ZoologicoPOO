package clases;

import zoo.Animal;

public class Reptil extends Animal {

    public Reptil() {
        super();
    }

    public Reptil(String n, String e, String a, int t) {
        super(n, e, a, t);
    }

    @Override
    public String toString() {
        return "\tTipo: Reptil" + super.toString() + "\tComportamiento: " + super.getComportamiento();
    }

    @Override
    public String mostrar() {
        return ("Nombre: " + getNombre() + "\tEspecie: " + getEspecie() + "\tSe encuentran: " + getTotal()
                + "\tAlimentacion: " + getAlimentacion());
    }
}