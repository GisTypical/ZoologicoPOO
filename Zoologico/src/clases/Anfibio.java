package clases;
import zoo.*;

public class Anfibio extends Animal {

    public Anfibio(){
        super();
    }
    public Anfibio (String n, String e, String a, int t){
        super(n, e, a, t);
    }

    public String toString(){
        return "\tTipo: Anfibio" + super.toString() + "\tComportamiento: " + super.getComportamiento(); 
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre: " + getNombre() + "\tEspecie: " + getEspecie()  + "\tSe encuentran: " + getTotal() + "\tAlimentacion: " + getAlimentacion());
    }
}