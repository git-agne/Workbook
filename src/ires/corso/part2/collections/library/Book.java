package ires.corso.part2.collections.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book
{
    //    - Libro (autore, data pubblicazione, num. pagine, num. capitoli)

    private String author;
    private String title;
    private LocalDate publicationDate;
    private int numPages;
    private int numChapters;

    public List<Category> bookCategory = new ArrayList<>();

    private static Map<Book, List<Category>> bookCategoryMap = new HashMap<>();

    private static void addToMap(Book k, Category v) {
        List<Category> categories;
        if(bookCategoryMap.containsKey(k)) {
            bookCategoryMap.get(k).add(v);
        }
        else {
            categories = new ArrayList<>();
            categories.add(v);
            bookCategoryMap.put(k, categories);
        }
    }

    public static List<Category> getCategoryByBook(Book b) {
        return bookCategoryMap.get(b);
    }

    public void addCategory(Category c) {
        bookCategory.add(c);
        addToMap(this, c);
    }

    public Book(String author, String title, LocalDate publicationDate, int numPages, int numChapters) {
        this.author = author;
        this.title = title;
        this.publicationDate = publicationDate;
        this.numPages = numPages;
        this.numChapters = numChapters;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public int getNumPages() {
        return numPages;
    }

    public int getNumChapters() {
        return numChapters;
    }
}
