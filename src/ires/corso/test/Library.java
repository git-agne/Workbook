package ires.corso.test;

import java.util.*;

public class Library
{
    private Integer id;
    private Map<Integer, Book> bookMap = new HashMap<>();
    public static Library library = null;

    public int getId() {
        ++id;
        return id;
    }

    public void addBook(Book b) {
        b.setId(getId());
        bookMap.put(b.getId(), b);
        // Serializza
    }

    public void removeBook(Integer id) {
        if(bookMap.containsKey(id)) {
            bookMap.remove(id);
        }
        else {
            Application.display("ID non valido.");
        }
        // Serializza
    }

    public void updateBook(Book b) {
        Set<Integer> idSet = bookMap.keySet();
        Iterator<Integer> idIter = idSet.iterator();

        while(idIter.hasNext()) {
            if(idIter.next().intValue() == b.getId()) {
                bookMap.put(b.getId(), b);
                // Serializza
                System.out.println("Modifica apportata.");
            }
            else {
                System.out.println("Il libro non esiste.");
            }
        }
    }

    public Book getBookByID(Integer id) {
        return bookMap.get(id);
    }

    public ArrayList<Book> getBookList() {
        ArrayList<Book> bookList = new ArrayList<>();

        for(Book b: bookMap.values()) {
            bookList.add(b);
        }
        return bookList;
    }

    public static Library getLibrary() {
        if(library == null) {
            library = new Library();
        }
        // Inizializzazione file con serializzazione con in repository
        return library;
    }

    private Library() { }
}
