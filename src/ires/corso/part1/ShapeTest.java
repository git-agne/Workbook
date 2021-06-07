package ires.corso.part1;

import ires.corso.part1.geometric.Quadrato;
import ires.corso.part1.geometric.Trapezio;
import ires.corso.part1.geometric.Triangolo;

import java.util.Scanner;

/**
 * Scrivere un programma Java che esegue le seguenti operazioni:
 * 1. chiede all'utente per che tipo di forma geometrica desidera calcolare l'area
 * 2. le figure da trattare sono 3: Quadrato, Triangolo, Trapezio
 * 3. per la figura prescelta, chiede i parametri necessari al calcolo dell'area
 * 4. calcola l'area utilizzando l'apposita formula geometrica
 * 5. stampa il risultato
 *
 * Utilizzare per le parti di codice specifiche di una figura tre classi,
 * implementando i relativi metodi come "static": Quadrato.java, Trapezio.java, Triangolo.java
 *
 * Per l'input utilizzare la classe Scanner; per discriminare tra le classi da chiamare usate un'istruzione switch
 */
public class ShapeTest {

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        Quadrato q = new Quadrato();
        Trapezio t = new Trapezio();
        Triangolo tria = new Triangolo();

        System.out.println("Scegli l'area da calcolare:");
        System.out.println("1 - Quadrato");
        System.out.println("2 - Trapezio");
        System.out.println("3 - Triangolo");

        int choice = s.nextInt();

        switch(choice){
            case 1:
                System.out.println("Inserisci il lato: ");
                double l = s.nextDouble();

                System.out.println("L'area è " + Quadrato.computeArea(l));
                break;

            case 2:
                System.out.println("Inserisci base maggiore, base minore e altezza: ");
                double bmaj = s.nextDouble();
                double bmin = s.nextDouble();
                double h = s.nextDouble();

                System.out.println("L'area è " + Trapezio.computeArea(bmaj, bmin, h));
                break;

            case 3:
                System.out.println("Inserisci base e altezza: ");
                double b = s.nextDouble();
                double h2 = s.nextDouble();

                System.out.println("L'area è " + Triangolo.computeArea(b, h2));
                break;
        }
    }
}
