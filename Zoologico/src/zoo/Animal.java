package zoo;

import interfaces.AnimalComportamiento;

public abstract class Animal implements AnimalComportamiento{
    public String nombre;
    public String especie;
    public String alimentacion;
    public String conducta;
    public int total;

    //---------Constructores---------
    public Animal(){
    }

    public Animal(String n, String e, String a, int t){
        nombre = n;
        especie = e;
        alimentacion = a;
        total = t;
    }

    //----------Setters and Getters------------
    public void setNombre(String n){
        this.nombre = n;
    }

    public String getNombre(){
        return nombre;
    }

    public void setEspecie(String e){
        this.especie = e;
    }

    public String getEspecie(){
        return especie;
    }

    public void setAlimentacion(String a){
        this.alimentacion = a;
    }

    public String getAlimentacion(){
        return alimentacion;
    }

    public void setTotal (int t){
        this.total = t;
    }

    public int getTotal(){
        return total;
    }

    public void setComportamiento(String c){
        this.conducta = c;
    }

    public String getComportamiento(){
        return conducta;
    }

    //-----Metodos--------
    public String toString(){
        return "\tNombre: " + getNombre() + "\tEspecie: " + getEspecie()  + "\tTotal: " + getTotal() + "\tComida: " + getAlimentacion();
    }

    public abstract void mostrar();

}