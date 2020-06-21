package zoo;

import java.util.ArrayList;
import java.util.Scanner;

import clases.*;

public class Main {
    public static void main(String[] args){

        //Instancias

        Pez p1 = new Pez("Pez Payaso", "A. chagosensis", "Herbivoro", 10);
        p1.setComportamiento("Nadar\n");

        Pez p2 = new Pez("Pez Espada", "X. gladius", "Carnivoro", 5);
        p2.setComportamiento("Nadar\n");

        Pez p3 = new Pez("Tiburon Blanco", "C. carcharias", "Carnivoro", 2);
        p3.setComportamiento("Cazar\n");

        Mamifero m1 = new Mamifero("Guepardo", "A. jubatus", "Carnivoro", 3);
        m1.setComportamiento("Correr\n");

        Mamifero m2 = new Mamifero("Oso Pardo", "U. arctos", "Omnivoro", 4);
        m2.setComportamiento("Cazar\n");

        Mamifero m3 = new Mamifero("Elefante", "L. cyclotis", "Herbivoro", 3);
        m3.setComportamiento("Caminar\n");

        Ave a1 = new Ave("Pinguino Rey", "A. patagonicus", "Carnivoro", 6);
        a1.setComportamiento("Nadar\n");

        Ave a2 = new Ave("avestruz", "S. camelus", "Herbivoro", 4);
        a2.setComportamiento("Correr\n");

        Ave a3 = new Ave("Pavo Real", "P. cristatus", "Herbivoro", 1);
        a3.setComportamiento("Caminar\n");

        Reptil r1 = new Reptil("Cocodrilo", "C. crocodilus", "Carnivoro", 2);
        r1.setComportamiento("Caminar y Nadar\n");

        Reptil r2 = new Reptil("Morrocoy", "C. carbonaria", "Herbivora", 6);
        r2.setComportamiento("Caminar\n");

        Reptil r3 = new Reptil("Camaleon", "C. chamaeleon", "Insectivoro", 9);
        r3.setComportamiento("Caminar\n");

        Anfibio an1 = new Anfibio("Sapo Comun", "B. bufo", "Insectivoro", 14);
        an1.setComportamiento("Saltar\n");

        Anfibio an2 = new Anfibio("Rana Dorada", "P. terribilis", "Insectivoro", 1);
        an2.setComportamiento("Venenosa\n");

        Anfibio an3 = new Anfibio("Cecilias", "P. terribilis", "Insectivoro", 7);
        an3.setComportamiento("Arrastrar\n");

        //Creacion de Arraylists

        ArrayList<Mamifero> mamiferos = new ArrayList<Mamifero>();
        ArrayList<Anfibio> anfibios = new ArrayList<Anfibio>();
        ArrayList<Pez> peces = new ArrayList<Pez>();
        ArrayList<Reptil> reptiles = new ArrayList<Reptil>();
        ArrayList<Ave> aves = new ArrayList<Ave>();

        mamiferos.add(m1);
        mamiferos.add(m2);
        mamiferos.add(m3);
        anfibios.add(an1);
        anfibios.add(an2);
        anfibios.add(an3);
        aves.add(a1);
        aves.add(a2);
        aves.add(a3);
        reptiles.add(r1);
        reptiles.add(r2);
        reptiles.add(r3);
        peces.add(p1);
        peces.add(p2);
        peces.add(p3);

        Scanner scanear = new Scanner(System.in); 
        System.out.println("1. Mostrar lista Mamiferos\n2. Mostrar Lista Aves\n3. Mostrar Lista Reptiles\n4. Mostrar Lista Anfibios");
        int key = scanear.nextInt(); 
        switch (key) {
            case 1:
                System.out.println(mamiferos);
                break;
        
            default:
                break;
        }

    }
}