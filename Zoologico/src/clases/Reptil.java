package clases;

import zoo.Animal;

public class Reptil extends Animal {
    
    public Reptil() {
        super();
    }

    public Reptil(String n, String e, String a, int t) {
        super(n, e, a, t); 
    }
    
    public String toString(){
        return "Tipo: Reptil" + super.toString() + "\tComportamiento: " + super.getComportamiento();
    }

    @Override
    public void mostrar(){
        System.out.println("Nombre: " + getNombre() + "\tEspecie: " + getEspecie()  + "\tSe encuentran: " + getTotal() + "\tAlimentacion: " + getAlimentacion());
    }
}