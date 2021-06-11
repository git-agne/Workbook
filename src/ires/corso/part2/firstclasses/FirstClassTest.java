package ires.corso.part2.firstclasses;

import ires.corso.part2.firstclasses.classes.Automobile;
import ires.corso.part2.firstclasses.classes.Zaino;

import java.util.Scanner;

// Create 2 classi a vostro piacimento, ispirandovi agli oggetti che + vi piacciono.
//
// Includete:
// - almeno un  campo int/long
// - almeno un campo Stringa
// - almeno un campo boolean

// TUTTE le variabili devono essere "private"

// Aggiungete:
// - getter e setter per tutti i campi
// - un costruttore diverso da quello di default che accetta almeno 2 argomenti e li imposta come valore dei campi
// - un metodo "prettyPrint" che stampa in console le caratteristiche dell'istanza

// Fate un test creando almeno un'istanza di ciascuna classe

public class FirstClassTest {
    public static void main(String[] args){

        Automobile a = new Automobile("Ford",1000);
        Zaino z = new Zaino("Antonio", 15);

        a.prettyPrint();
        z.prettyPrint();
    }
}
