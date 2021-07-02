package ires.corso.part3;

import java.util.*;
import java.util.stream.Stream;

public class LambdaTest {
    // 1. Data una lista di nomi (Agnese, Stefano, Niki, GabrieleM, Davide, GabrieleG, Alessandro, Alberto, Fabiola, Veronica, Alessio, Daniele):
    // partire con un ArrayList che li contiene;
    // trasformarlo in stream
    // filtrare (escludendo) i nomi che hanno lunghezza < di 5 lettere
    // trasformare con UpperCase i rimanenti
    // stamparli su schermo
    // … concatenando il più possibile le varie operazioni

    public static void main(String[] args) {
        List<String> namesList = Arrays.asList(
                "Agnese",
                "Veronica",
                "Fabiola",
                "Stefano",
                "Niki",
                "GabrieleM",
                "GabrieleG",
                "Davide",
                "Alessandro",
                "Alberto",
                "Alessio",
                "Daniele");

        namesList.stream().filter(s -> s.length() > 5).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        // 2. Fare un programma Java che:
        // chiede all’utente una lista di numeri (separati da virgola) ⇒ codice SortingGame, o split Stringa
        // li trasforma in stream
        // filtra i duplicati (HINT: guardate bene i metodi dell’interfaccia Stream)
        // eleva al quadrato i numeri filtrati
        // calcola la media (HINT: operazione terminale chiamata “average”)

        Scanner scan = new Scanner(System.in);
        System.out.println("\nInserisci lista di numeri separati da virgola: ");
        String input = scan.nextLine();
        String[] strings = input.split(",");
        List<Double> listInt = new ArrayList<>();
        for(String s: strings) {
            Double i = Double.parseDouble(s);
            listInt.add(i);
        }

        listInt.stream().distinct().map(i -> i * i).forEach(i -> System.out.println(i));
        // Perchè non funziona average()
    }
}



