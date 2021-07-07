package ires.corso.test;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class Library implements Serializable
{
    private long idSeed;
    Map<Long, Book> bookMap = new HashMap<>();

    public static Library library = null;
    private static String fileName = "library.ser";

    public long getNewId() {
        idSeed++;
        return idSeed;
    }

    public static void writeToFile() {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(library);

            out.close();
            file.close();
        }
        catch(IOException e) {
            System.out.println(e + " is Caught.");
        }
    }

    public static void loadFromFile() {
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            library = (Library) in.readObject();

            in.close();
            file.close();
        }
        catch(IOException | ClassNotFoundException e) {
            System.out.printf(e + " is caught.");
        }
    }

    public void addBook(Book b) {
        b.setId(getNewId());
        bookMap.put(b.getId(), b);

        writeToFile();
    }

    public void removeBook(Integer id) {
        if(bookMap.containsKey(id)) {
            bookMap.remove(id);
        }
        else {
            Application.display("ID non valido.");
        }

        writeToFile();
    }

    public void updateBook(Book b) {
        Set<Long> idSet = bookMap.keySet();
        Iterator<Long> idIter = idSet.iterator();

        while(idIter.hasNext()) {
            if(idIter.next().intValue() == b.getId()) {
                bookMap.put(b.getId(), b);

                writeToFile();
                System.out.println("Modifica apportata.");
            }
            else {
                System.out.println("Il libro non esiste.");
            }
        }
    }

    public void updateAdvancement(Long id, int advancement) {
        if(bookMap.containsKey(id)) {
            if(bookMap.get(id).getReadingAdvancement() < 100) {
                bookMap.get(id).setReadingAdvancement(advancement);

                writeToFile();
            }
            else if(bookMap.get(id).getReadingAdvancement() >= 100) {
                System.out.println("Lettura completata, impossibile modificare l'avanzamento.");
            }
        }
        else {
            System.out.println("ID non valido.");
        }
    }

    public void updateJudgment(Long id, int judgment) {
        if(bookMap.containsKey(id)) {
            bookMap.get(id).setPersonalJudgment(judgment);

            writeToFile();
        }
        else {
            System.out.println("ID non valido.");
        }
    }

    public Book getBookByID(Long id) {
        if(bookMap.containsKey(id)) {
            return bookMap.get(id);
        }
        else {
            System.out.println("ID non valido.");
            return null;
        }
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

        if(!Paths.get(fileName).toFile().exists()){
            writeToFile();
            loadFromFile();
        } else {
            loadFromFile();
        }
        return library;
    }

    private Library() { }
}
