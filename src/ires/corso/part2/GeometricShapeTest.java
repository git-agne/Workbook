package ires.corso.part2;

// ...dovete riscrivere in versione OOP (object oriented programming)
// il programma che calcolava le aree di triangolo, trapezio, quadrato:
// 1. Create una classe "MasterShape" che sarà la classe "parent"
// 2. all'interno di "MasterShape" definite il metodo computeArea
//    e il metodo il metodo computePerimeter, che NON devono ricevere
//    argomenti in input: questi metodi devono restituire 0.0
// 3. Usate i costruttori specifici delle classi figlie per richiedere
//    al momento della creazione i parametri che servono per fare i
//    calcoli in ciascuna forma geometrica
// 4. Le classi figlie (Trapezio, Triangolo, Quadrato) devono ESTENDERE
//    (con "extends") la MasterShape e implementare l'OVERRIDE dei metodi
//    computeArea e computePerimeter (nota: aggiungere l'annotation @Override)
// 5. Create una classe Tester con il metodo main(String[] args), all'interno
//    del quale dovrete:
//    - creare 3 forme geometriche diverse, come istanze delle classi figlie: chiedete
//      i dati in input nel metodo main e salvateli nelle proprietà interne
//      di ciascuna classe
//    - creare un array di MasterShape che avrà come elementi le istanze create
//    - calcolare le aree e stamparle in un unico loop (come "ilConto")

import ires.corso.part2.firstclasses.geometric2.MasterShape;
import ires.corso.part2.firstclasses.geometric2.Square;
import ires.corso.part2.firstclasses.geometric2.Trapezium;
import ires.corso.part2.firstclasses.geometric2.Triangle;

import java.util.Scanner;

public class GeometricShapeTest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Quadrato: inserisci la misura del lato: ");
        Square s = new Square(scan.nextDouble());

        System.out.println("Triangolo: inserisci base e altezza: ");
        Triangle tria = new Triangle(scan.nextDouble(), scan.nextDouble());

        System.out.println("Trapezio: inserisci base minore, base maggiore e altezza: ");
        Trapezium trap = new Trapezium(scan.nextDouble(), scan.nextDouble(), scan.nextDouble());

        // Inserire controlli per i dati con metodi statici, poi da passare al costruttore
        // Dopo aver inserito i dati, controllare che le figure non siano NULLE

        MasterShape[] shapeArr = new MasterShape[3];
        shapeArr[0] = s;
        shapeArr[1] = tria;
        shapeArr[2] = trap;

        for(int i = 0; i < shapeArr.length; i++){

            System.out.printf("L'area è di %f\n", shapeArr[i].computeArea());
        }
    }
}
