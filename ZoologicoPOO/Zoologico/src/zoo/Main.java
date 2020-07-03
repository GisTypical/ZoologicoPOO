package zoo;

import java.util.ArrayList;
//import java.util.Scanner;

import UI.*;
import clases.*;

public class Main {
    public static void main(String[] args){
        new UI2();

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
        r3.setComportamiento("Camuflajear\n");

        Anfibio an1 = new Anfibio("Sapo Comun", "B. bufo", "Insectivoro", 14);
        an1.setComportamiento("Saltar\n");

        Anfibio an2 = new Anfibio("Rana Dorada", "P. terribilis", "Insectivoro", 1);
        an2.setComportamiento("Envenenar\n");

        Anfibio an3 = new Anfibio("Cecilias", "P. terribilis", "Insectivoro", 7);
        an3.setComportamiento("Arrastrar\n");

        //Creacion de Arraylists

        ArrayList<Mamifero> mamiferos = new ArrayList<Mamifero>();
        ArrayList<Anfibio> anfibios = new ArrayList<Anfibio>();
        ArrayList<Pez> peces = new ArrayList<Pez>();
        ArrayList<Reptil> reptiles = new ArrayList<Reptil>();
        ArrayList<Ave> aves = new ArrayList<Ave>();

        //Agregar a los Arraylists
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

        /*Scanner scanear = new Scanner(System.in);
        String usuarioNombre = "", usuarioEspecie = "", usuarioAlimento = "", usuarioComportamiento = "";
        int key, usuarioTotal;
        do {
            System.out.println("-------Zoologico-------");
            System.out.println("1. Mostrar lista mamiferos\n2. Mostrar lista aves\n3. Mostrar lista reptiles\n4. Mostrar lista anfibios\n5. Mostrar lista de peces");
            System.out.print("6. Agregar un nuevo animal\n0. Salir\nSeleccion: ");
            key = scanear.nextInt();
            switch (key) {
                case 1:
                    System.out.println(mamiferos);
                    break;
                case 2: 
                    System.out.println(aves);
                    break;
                case 3:
                    System.out.println(reptiles);
                    break;
                case 4:
                    System.out.println(anfibios);
                    break;
                case 5:
                    System.out.println(peces);
                    break;
                case 6:
                    System.out.print("Nombre: ");
                    usuarioNombre = scanear.nextLine();
                    usuarioNombre += scanear.nextLine();
                    System.out.print("Especie: ");
                    usuarioEspecie = scanear.nextLine();
                    System.out.print("Alimento: ");
                    usuarioAlimento = scanear.nextLine();
                    System.out.print("Comportamiento: ");
                    usuarioComportamiento = scanear.nextLine();
                    System.out.print("Total en el Zoo: ");
                    usuarioTotal = scanear.nextInt();
                    System.out.print("\nEste animal pertenece a: \n1. Mamiferos\n2. Aves\n3. Reptiles\n4. Anfibios\n5. Peces\nSeleccion: ");
                    key = scanear.nextInt();
                    switch (key) {
                        case 1:
                            Mamifero usuarioMamifero = new Mamifero(usuarioNombre, usuarioEspecie, usuarioAlimento, usuarioTotal);
                            usuarioMamifero.setComportamiento(usuarioComportamiento);
                            mamiferos.add(usuarioMamifero);
                            break;
                        case 2: 
                            Ave usuarioAve = new Ave(usuarioNombre, usuarioEspecie, usuarioAlimento, usuarioTotal);
                            usuarioAve.setComportamiento(usuarioComportamiento);
                            aves.add(usuarioAve);
                            break;
                        case 3: 
                            Reptil usuarioReptil = new Reptil(usuarioNombre, usuarioEspecie, usuarioAlimento, usuarioTotal);
                            usuarioReptil.setComportamiento(usuarioComportamiento);
                            reptiles.add(usuarioReptil);
                            break;
                        case 4:
                            Anfibio usuarioaAnfibio = new Anfibio(usuarioNombre, usuarioEspecie, usuarioAlimento, usuarioTotal);
                            usuarioaAnfibio.setComportamiento(usuarioComportamiento);
                            anfibios.add(usuarioaAnfibio);
                            break;
                        case 5:
                            Pez usuarioPez = new Pez(usuarioNombre, usuarioEspecie, usuarioAlimento, usuarioTotal);
                            usuarioPez.setComportamiento(usuarioComportamiento);
                            peces.add(usuarioPez);
                            break;
                        default:
                            System.out.println("Opcion Invalida");
                            break;
                        }
                    System.out.println(usuarioNombre + " Agregado!\n");
                    break;
                case 0:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Opcion Invalida");
                    break;
            }
        } while (key != 0);
        scanear.close();*/
    }
}