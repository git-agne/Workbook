package ires.corso.part2.todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ToDoManager
{
    static Scanner scan = new Scanner(System.in);

    public ToDoManager() {
    }

    public static void createNewToDo() {
        ToDo newToDo;
        System.out.println("Aggiungi il titolo: ");
        String title = scan.nextLine();
        System.out.println("Aggiungi la descrizione: ");
        String description = scan.nextLine();
        System.out.println("Aggiungi la data di consegna nel formato AAAA/MM/GG: ");
        String data = scan.nextLine();
        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy/MM/d");
        LocalDate deliveryDate = LocalDate.parse(data, form);
        LocalDate insertionDate = LocalDate.now();
        System.out.println("Scegli la priorità:");
        System.out.println("1. Alta");
        System.out.println("2. Media");
        System.out.println("3. Bassa");
        String input = scan.nextLine();
        String res = null;
        switch (input) {
            case "1":
                res = "ALTA";
                break;
            case "2":
                res = "MEDIA";
                break;
            case "3":
                res = "BASSA";
                break;
            default:
                res = "ALTA";
        }

        newToDo = new ToDo(title, description, insertionDate, deliveryDate, ToDo.Priority.valueOf(res));

        ToDoRepository.getToDoRepository().add(newToDo);
    }

    public static void updateToDo() {
        System.out.println("Inserisci l'ID che vuoi modificare: ");
        Long id = Long.parseLong(scan.nextLine());

        ToDo cloneToDo = ToDoRepository.getToDoRepository().getToDoByID(id).cloneForUpdate();
        cloneToDo.setId(id);
        LocalDate oldDate = cloneToDo.getDeliveryDate();

        System.out.println("Modifica titolo: ");
        String title = scan.nextLine();
        if(title.length() > 0) {
            cloneToDo.setTitle(title);
        }
        System.out.println("Modifica descrizione: ");
        String description = scan.nextLine();
        if(description.length() > 0) {
            cloneToDo.setDescription(description);
        }
        System.out.println("Modifica data\n");
        System.out.println("Modifica l'anno: ");
        String year = scan.nextLine();

        if(year.length() > 0) {
            int y = Integer.parseInt(year);
            int day = oldDate.getDayOfMonth();
            int month = oldDate.getMonthValue();
            LocalDate newDate = LocalDate.of(y, month, day);
            cloneToDo.setDeliveryDate(newDate);
        }
        System.out.println("Modifica mese: ");
        String month = scan.nextLine();
        if(month.length() > 0) {
            int m = Integer.parseInt(month);
            int y = oldDate.getYear();
            int day = oldDate.getDayOfMonth();
            LocalDate newDate = LocalDate.of(y, m, day);
            cloneToDo.setDeliveryDate(newDate);
        }
        System.out.println("Modifica giorno: ");
        String day = scan.nextLine();
        if(day.length() > 0) {
            int d = Integer.parseInt(day);
            int m = oldDate.getMonthValue();
            int y = oldDate.getYear();
            LocalDate newDate = LocalDate.of(y, m, d);
            cloneToDo.setDeliveryDate(newDate);
        }

        System.out.println("Modifica priorità: ");
        System.out.println("1. Alta");
        System.out.println("2. Media");
        System.out.println("3. Bassa");
        String input = scan.nextLine();
        switch (input) {
            case "1":
                cloneToDo.setPriority(ToDo.Priority.ALTA);
                break;
            case "2":
                cloneToDo.setPriority(ToDo.Priority.MEDIA);
                break;
            case "3":
                cloneToDo.setPriority(ToDo.Priority.BASSA);
                break;
            default:
                break;
        }

        System.out.println("Modifica stato: ");
        System.out.println("1. Da fare");
        System.out.println("2. Completata");
        System.out.println("3. Annullata");
        System.out.println("4. In esecuzione");
        String status = scan.nextLine();
        switch(status) {
            case "1":
                cloneToDo.setState(ToDo.State.DA_FARE);
                break;
            case "2":
                cloneToDo.setState(ToDo.State.COMPLETATA);
                break;
            case "3":
                cloneToDo.setState(ToDo.State.ANNULLATA);
                break;
            case "4":
                cloneToDo.setState(ToDo.State.IN_ESECUZIONE);
                break;
        }
        ToDoRepository.getToDoRepository().update(cloneToDo);
    }

    public static void removeToDo() {
        System.out.println("Inserisci l'ID che vuoi eliminare: ");
        Long id = Long.parseLong(scan.nextLine());
        if(ToDoRepository.getToDoRepository()._data.containsKey(id)) {
            ToDoRepository.getToDoRepository().delete(id);
        }
        else {
            System.out.println("ID non valido.");
        }
    }
}
