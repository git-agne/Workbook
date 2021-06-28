package ires.corso.part2.collections.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loan
{
    //    - Prestito (utente, 1 o + libri)

    public List<Book> borrowedBooks = new ArrayList<>();

    public Loan(List<Book> loanedBooks) {
        this.borrowedBooks = loanedBooks;
    }

    public List<Book> getLoanedBooks() {
        return borrowedBooks;
    }
}
