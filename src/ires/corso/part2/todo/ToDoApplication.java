package ires.corso.part2.todo;

import java.util.Scanner;

public class ToDoApplication
{
    // 1. Deserializza il repository da file (carica i dati dell'ultimo salvataggio) -> invoca metodo ToDoRepository
    //    creando una classe Repository
    // 2. Gestione del menu principale con un loop e due switch
    // 3. In corrispondenza di una scelta dell'utente (ramo dello switch) chiama le classi
    //    necessarie per svolgere l'azione
    // 4. Chiede conferma e serializza in uscita
    // 5. Fornisce anche i metodi della classe "lettore" di quiz... askForInput(), display()

    public static void doMenu() {
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
                            // Invoco metodo per visualizzazione
                            break;
                        case "2":
                            break;
                        case "3":
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
                            // Invoco metodo per visualizzazione
                            break;
                        case "2":
                            break;
                        case "3":
                            break;
                    }
                    break;
                case "3":
                    display("1. Import da file");
                    display("2. Export su file");
                    userInput = askForInput();
                    switch(userInput) {
                        case "1":
                            // Invoco metodo per visualizzazione
                            break;
                        case "2":
                            break;
                    }
                    break;
                case "4":
                    display("Sei uscito dal programma.");
                    // Serializza
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
