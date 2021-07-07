package ires.corso.test;

import java.time.LocalDate;

public class Book
{
    public enum BookKind {
        FANTASY,
        GIALLO,
        STORICO
    }
    /*
    public enum PersonalJudgment {
        UNO,
        DUE,
        TRE,
        QUATTRO,
        CINQUE
    }
     */
    protected Integer id;
    private String title;
    private String author;
    private String description;
    private String isbn;
    private LocalDate publicationDate;
    private int personalJudgment;
    private BookKind kind;

    public Book cloneBook() {
        Book clonedBook = new Book(this.title, this.author, this.description, this.isbn, this.publicationDate, this.kind);
        return clonedBook;
    }

    public BookKind getKind() {
        return kind;
    }

    public void setKind(BookKind kind) {
        this.kind = kind;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPersonalJudgment() {
        return personalJudgment;
    }

    public void setPersonalJudgment(int personalJudgment) {
        this.personalJudgment = personalJudgment;
    }

    public Book(String title, String author, String description, String isbn, LocalDate publicationDate, BookKind kind) {
        this.author = author;
        this.description = description;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.kind = kind;
    }
}
