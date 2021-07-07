package ires.corso.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookList
{
    public void viewBookList() {
        Comparator<Book> compareByTitle = (Book b1, Book b2) -> b1.getId().compareTo(b2.getId());
        List<Book> bookList = getUpdatedList();

        if(bookList.size() > 0) {
            Collections.sort(bookList, compareByTitle);
            listPrinter(bookList);
        }
        else {
            Application.display("La lista è vuota.");
        }

    }

    public List<Book> getUpdatedList() {
        return Library.getLibrary().getBookList();
    }

    public void listPrinter(List<Book> lb) {
        for(Book b: lb) {
            Application.display("Id: " + b.getId());
            Application.display("Titolo: " + b.getTitle());
            Application.display("Autore: " + b.getAuthor());
            Application.display("Descrizione: " + b.getDescription());
            Application.display("ISBN: " + b.getIsbn());
            Application.display("Data di pubblicazione: " + b.getPublicationDate());
            Application.display("Genere: " + b.getKind());
            Application.display("Giudizio personale: " + b.getPersonalJudgment());
            Application.display("Avanzamento nella lettura: " + b.getReadingAdvancement() + "%");
            Application.display("\n");
        }
    }
}
