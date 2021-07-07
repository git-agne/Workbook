package ires.corso.test;

import java.util.Scanner;

public class Application
{
    public static void menu() {
        display("------------------------");
        display("- Biblioteca personale -");
        display("------------------------");

        display("1. Visualizza lista dei volumi");
        display("2. Aggiungi un volume");
        display("3. Modifica un volume");
        display("4. Eminina un volume");
        display("5. Aggiorna avanzamento lettura");
        display("6. Aggiorna giudizio personale");
        display("7. Uscita");

        String userInput = getInput();

        switch(userInput) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
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

    public static String getInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static void display(String s) {
        System.out.println(s);
    }
}
