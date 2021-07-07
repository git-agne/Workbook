package ires.corso.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookList
{
    public void viewBookList() {
        Comparator<Book> compareByTitle = (Book b1, Book b2) -> b1.getTitle().compareTo(b2.getTitle());
        List<Book> bookList = getUpdatedList();

        if(bookList.size() > 0) {
            Collections.sort(bookList, compareByTitle);
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
        }
    }
}
