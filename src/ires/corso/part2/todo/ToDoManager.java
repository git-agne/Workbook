package ires.corso.part2.todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ToDoManager
{
    // Classe responsabile per le operazioni sull'insieme dei TO-DO
    // - metodi creazione nuovo TO-DO
    // - metodi per modifica, rimozione
    // - gestisce input utente (cioè loop di richiesta di quali campi devono essere modificati)
    // ha al suo interno funzioni di controllo sull'input utente

    Scanner scan = new Scanner(System.in);

    public void createNewToDo() {
        ToDo newToDo;
        System.out.println("Aggiungi il titolo: ");
        String title = scan.nextLine();
        System.out.println("Aggiungi la descrizione: ");
        String description = scan.nextLine();
        System.out.println("Aggiungi la data di consegna nel formato AAAA/MM/GG: ");
        String data = scan.nextLine();
        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/MM/d");
        LocalDate deliveryDate = LocalDate.parse(data, form);
        LocalDate insertionDate = LocalDate.now();

        newToDo = new ToDo(title, description, insertionDate, deliveryDate);
    }

    public void updateToDo() {
        // Chiede quale Id si vuole modificare
        // Si chiede un "clone" del TO-DO
        // Loop di richiesta dati da modificare
        // Salvataggio delle modifiche tramite ToDoRepostory (update...)

    }
}
