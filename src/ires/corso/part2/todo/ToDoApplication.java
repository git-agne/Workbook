package ires.corso.part2.todo;

import java.io.IOException;
import java.util.Scanner;

public class ToDoApplication
{
    public static ToDoList tdl;
    static {
        try {
            tdl = new ToDoList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doMenu() throws Exception {
        while(true) {
            display("--------------------------------");
            display("________** TO-DO LIST **________");
            display("--------------------------------");
            display("");
            display("1. Visualizza la lista.");
            display("2. Aggiungi, Rimuovi, Modifica");
            display("3. Import/Export");
            display("4. Esci");

            String userInput = askForInput();

            switch(userInput) {
                case "1":
                    display("1. Per priorità");
                    display("2. Per data");
                    display("3. Per stato");

                    userInput = askForInput();

                    switch(userInput) {
                        case "1":
                            tdl.viewByPriority();
                            break;
                        case "2":
                            tdl.viewByDate();
                            break;
                        case "3":
                            tdl.viewByStatus();
                            break;
                        default:
                            display("Inserisci un carattere valido.");
                            break;
                    }
                    break;
                case "2":
                    display("1. Aggiungi");
                    display("2. Rimuovi");
                    display("3. Modifica");

                    userInput = askForInput();
                    switch(userInput) {
                        case "1":
                            ToDoManager.createNewToDo();
                            break;
                        case "2":
                            ToDoManager.removeToDo();
                            break;
                        case "3":
                            ToDoManager.updateToDo();
                            break;
                    }
                    break;
                case "3":
                    display("1. Import da file");
                    display("2. Export su file");

                    userInput = askForInput();
                    switch(userInput) {
                        case "1":
                            ToDoImportExport.importFromFile();
                            break;
                        case "2":
                            ToDoImportExport.exportToFile();
                            break;
                    }
                    break;
                case "4":
                    display("Sei uscito dal programma.");
                    System.exit(0);
                    break;
            }
        }
    }

    public static String askForInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static void display(String s) {
        System.out.println(s);
    }
}
