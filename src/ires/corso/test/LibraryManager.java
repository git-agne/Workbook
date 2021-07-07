package ires.corso.test;

import ires.corso.part2.todo.ToDo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LibraryManager
{
    public static void insertNewBook() {
        Book newBook;

        Application.display("Aggiungi il titolo del libro: ");
        String title = Application.getInput();
        Application.display("Aggiungi l'autore del libro: ");
        String author = Application.getInput();
        Application.display("Aggiungi una breve descrizione del libro: ");
        String description = Application.getInput();
        Application.display("Aggiungi il codice ISBN: ");
        String isbn = Application.getInput();
        Application.display("Aggiungi la data di pubblicazione nel formato AAAA-MM-GG: ");
        String data = Application.getInput();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate publicationDate = LocalDate.parse(data, dtf);
        Application.display("Scegli il genere: ");
        Application.display("1. Fantasy");
        Application.display("2. Giallo");
        Application.display("3. Storico");
        String input = Application.getInput();
        String kind = null;
        switch(input) {
            case "1":
                kind = "FANTASY";
                break;
            case "2":
                kind = "GIALLO";
                break;
            case "3":
                kind = "STORICO";
                break;
        }

        newBook = new Book(title, author, description, isbn, publicationDate, Book.BookKind.valueOf(kind));

        Library.getLibrary().addBook(newBook);
    }

    public static void updateBook() {
        Application.display("Inserisci l'ID del libro che vuoi modificare: ");
        Long idInput = Long.parseLong(Application.getInput());

        Book bookClone = Library.getLibrary().getBookByID(idInput).cloneBook();
        bookClone.setId(idInput);

        LocalDate oldDate = bookClone.getPublicationDate();

        Application.display("Modifica titolo: ");
        String title = Application.getInput();
        if(title.length() > 0) {
            bookClone.setTitle(title);
        }
        Application.display("Modifica autore: ");
        String author = Application.getInput();
        if(author.length() > 0) {
            bookClone.setAuthor(author);
        }
        Application.display("Modifica descrizione: ");
        String description = Application.getInput();
        if(description.length() > 0) {
            bookClone.setDescription(description);
        }
        Application.display("Modifica ISBN: ");
        String isbn = Application.getInput();
        if(isbn.length() > 0) {
            bookClone.setIsbn(isbn);
        }

        Application.display("Modifica data di pubblicazione:");
        Application.display("Modifica anno:");
        String year = Application.getInput();
        if(year.length() > 0) {
            int y = Integer.parseInt(year);
            int d = oldDate.getDayOfMonth();
            int m = oldDate.getMonthValue();
            LocalDate newDate = LocalDate.of(y, m, d);
            bookClone.setPublicationDate(newDate);
        }
        System.out.println("Modifica mese: ");
        String month = Application.getInput();
        if(month.length() > 0) {
            int m = Integer.parseInt(month);
            int y = oldDate.getYear();
            int d = oldDate.getDayOfMonth();
            LocalDate newDate = LocalDate.of(y, m, d);
            bookClone.setPublicationDate(newDate);
        }
        System.out.println("Modifica giorno: ");
        String day = Application.getInput();
        if(day.length() > 0) {
            int d = Integer.parseInt(day);
            int m = oldDate.getMonthValue();
            int y = oldDate.getYear();
            LocalDate newDate = LocalDate.of(y, m, d);
            bookClone.setPublicationDate(newDate);
        }

        System.out.println("Modifica il genere: ");
        System.out.println("1. Fantasy");
        System.out.println("2. Giallo");
        System.out.println("3. Storico");
        String input = Application.getInput();
        switch (input) {
            case "1":
                bookClone.setKind(Book.BookKind.FANTASY);
                break;
            case "2":
                bookClone.setKind(Book.BookKind.GIALLO);
                break;
            case "3":
                bookClone.setKind(Book.BookKind.STORICO);
                break;
            default:
                break;
        }

        Library.getLibrary().updateBook(bookClone);
    }

    public static void deleteBook() {
        Application.display("Inserisci l'ID del libro da eliminare:");
        int idInput = Integer.parseInt(Application.getInput());

        Library.getLibrary().removeBook(idInput);
    }

    public static void updateReadingAdvancement() {
        Application.display("Inserisci l'ID del libro di cui vuoi aggiornare l'avanzamento:");
        Long idInput = Long.parseLong(Application.getInput());

        Application.display("Inserisci un numero da 1 a 100 che rappresenta la percentuale già letta del volume: ");
        int advancement = Integer.parseInt(Application.getInput());

        Library.getLibrary().updateAdvancement(idInput, advancement);
    }

    public static void updateJudgment() {
        Application.display("Inserisci l'ID del libro di cui vuoi aggiornare l'avanzamento:");
        Long idInput = Long.parseLong(Application.getInput());

        Application.display("Inserisci un voto da 1 a 5: ");
        int judgment = Integer.parseInt(Application.getInput());

        Library.getLibrary().updateJudgment(idInput, judgment);
    }
}
