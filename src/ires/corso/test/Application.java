package ires.corso.test;

import java.io.IOException;
import java.util.Scanner;

public class Application
{
    public static BookList bl = new BookList();

    public static void menu() throws IOException {
        while(true) {
            display("------------------------");
            display("- Biblioteca personale -");
            display("------------------------");

            display("1. Visualizza lista dei volumi");
            display("2. Aggiungi un volume");
            display("3. Modifica un volume");
            display("4. Elimina un volume");
            display("5. Aggiorna avanzamento lettura");
            display("6. Aggiorna giudizio personale");
            display("7. Esporta lista");
            display("8. Uscita");

            String userInput = getInput();

            switch(userInput) {
                case "1":
                    bl.viewBookList();
                    break;
                case "2":
                    LibraryManager.insertNewBook();
                    break;
                case "3":
                    LibraryManager.updateBook();
                    break;
                case "4":
                    LibraryManager.deleteBook();
                    break;
                case "5":
                    LibraryManager.updateReadingAdvancement();
                    break;
                case "6":
                    LibraryManager.updateJudgment();
                    break;
                case "7":
                    LibraryExport.exportToFile();
                    break;
                case "8":
                    display("Sei sicuro di voler uscire?");
                    display("1. Sì");
                    display("2. No");

                    userInput = getInput();

                    switch(userInput) {
                        case "1":
                            display("Sei uscito dal programma.");
                            System.exit(0);
                            break;
                        case "2":
                            break;
                    }
            }
        }

    }

    public static String getInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static void display(String s) {
        System.out.println(s);
    }
}
