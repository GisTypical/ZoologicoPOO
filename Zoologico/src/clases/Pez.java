package clases;
import zoo.*;

public class Pez extends Animal{
    
    public Pez(){
        super();
    }
    public Pez (String n, String e, String a, int t){
        super(n, e, a, t);
    }
    public String toString(){
        return "Tipo: Pez" + super.toString() + "\tComportamiento: " + getComportamiento();
    }
    @Override
    public void mostrar() {
        System.out.println("Nombre: " + getNombre() + "\tEspecie: " + getEspecie()  + "\tSe encuentran: " + getTotal() + "\tAlimentacion: " + getAlimentacion());
    }
}