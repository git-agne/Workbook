package ires.corso.part2.collections.library;

import java.time.LocalDate;
import java.util.*;

public class LibraryManager {
    public static void main(String[] args) {
        //    Create almeno 8 libri diversi e 5 categorie diverse.
        //    Almeno 4 Libri devono essere associati a più di una categoria. (MAP ??)
        //    Rappresentate opportunamente l'associazione tra libri e categorie in una struttura (basata sulle Java
        //    collections) che permetta di ricavare agevolmente a quali categorie appartiene un Libro.
        //
        //    Create poi almeno 3 utenti diversi.
        //    Per ciascun utente, create almeno 2 prestiti, con 2 o + volumi appartenenti a categorie distinte.
        //    Rappresentate opportunamente l'associazione tra utenti e prestiti tramite una struttura (basata sulle
        //    Java collections) che permetta di ricavare agevolmente quali prestiti ha eseguito un utente.
        //
        //    Incrociate i dati delle due strutture per costruire una terza struttura (Java collection) che dica
        //    quanti e quali prestiti sono stati eseguiti per ciascuna categoria (vogliamo fare un'analisi statistica
        //    di quali siano le categorie più gradite).

        Book b1 = new Book("J.R.R. Tolkien", "Il Silmarillion", LocalDate.of(1977, 9,15), 1200, 3);
        Book b2 = new Book("Fred Vargas", "Chi è morto alzi la mano", LocalDate.of(1995, 6, 1), 258, 10);
        Book b3 = new Book("Alessandro Barbero", "Gli occhi di Venezia", LocalDate.of(2011, 6, 1), 258, 10);

        Category cat1 = new Category("Fantasy", "Libri fantasy");
        Category cat2 = new Category("Gialli", "Libri gialli");
        Category cat3 = new Category("Storici", "Libri storici");

        User us1 = new User("Elena", "Verdi", 123);
        User us2 = new User("Mario", "Rossi", 456);

        ArrayList<Book> listUs1 = new ArrayList<>();
        listUs1.add(b1);
        ArrayList<Book> listUs3 = new ArrayList<>();
        listUs3.add(b1);
        listUs3.add(b3);
        ArrayList<Book> listUs2 = new ArrayList<>();
        listUs2.add(b2);

        us1.addLoan(new Loan(listUs1));
        us1.addLoan(new Loan(listUs3));
        us2.addLoan(new Loan(listUs3));

        b1.addCategory(cat1);
        b2.addCategory(cat2);
        b3.addCategory(cat3);

        Iterator<Book> iBook = listUs3.iterator();
        while(iBook.hasNext()) {
            System.out.printf("Titolo: %s\n", iBook.next().getTitle());
        }

        for(Category c: b1.bookCategory) {
            System.out.println(c.getTitle());
        }

        /*
        for(Loan l: User.getLoanById(123)) {
            for(Book b: l.borrowedBooks) {
                System.out.println("Libri presi in prestito: " + b.getTitle());
            }
        }

        for(Category c: Book.getCategoryByBook(b3)) {
            System.out.println("Categoria: " + c.getTitle());
        }

         */
    }
}
