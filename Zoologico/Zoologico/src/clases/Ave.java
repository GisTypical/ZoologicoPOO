package clases;
import zoo.*;

public class Ave extends Animal{
    //Constructores
    public Ave (){
        super();
    }
    public Ave (String n, String e, String a, int t){
        super(n, e, a, t);
    }

    public String toString(){
        return "\tTipo: Ave" + super.toString() + "\tComportamiento: " +super.getComportamiento();
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre: " + getNombre() + "\tEspecie: " + getEspecie()  + "\tSe encuentran: " + getTotal() + "\tAlimentacion: " + getAlimentacion());
    }
}