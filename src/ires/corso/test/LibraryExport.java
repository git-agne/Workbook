package ires.corso.test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class LibraryExport
{
    private static String outputFileName = "LibraryOutput.txt";

    private static String convertToString(Book b) {
        String bookString = String.format("%s|%s|%s|%s|%s|%s|%s|%s", b.getTitle(), b.getAuthor(), b.getDescription(), b.getIsbn(),
                b.getPublicationDate().toString(), b.getKind().toString(), b.getPersonalJudgment(), b.getReadingAdvancement());
        return bookString;
    }

    public static void exportToFile() throws IOException {
        try(PrintWriter output = new PrintWriter(new FileWriter(outputFileName))) {
            ArrayList<Book> bList = Library.getLibrary().getBookList();
            Iterator<Book> bookIter = bList.iterator();

            while(bookIter.hasNext()) {

                String bookString = convertToString(bookIter.next());
                output.println(bookString);
            }
            Application.display("Lista esportata.");
        }
    }
}
