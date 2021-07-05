package ires.corso.part2.todo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ToDoList
{
    // Implementa le funzionalità di visualizzazione con:
    // - ordinamento per priorità
    // - ordinamento per data
    // - ordinamento per stato
    // Si appoggia ai metodi di ToDoRepository per avere una lista (= copia dei TO-DO originali)
    // dei TO-DO attualmente a sistema, cioè un ArrayList facilmente utilizzabile

    Comparator<ToDo> compareByPriority = (ToDo t1, ToDo t2) -> t1.getPriority().compareTo(t2.getPriority());

    Comparator<ToDo> compareByStatus = (ToDo t1, ToDo t2) -> t1.getState().compareTo(t2.getState());

    Comparator<ToDo> compareByDate = (ToDo t1, ToDo t2) -> t1.getDeliveryDate().compareTo(t2.getDeliveryDate());

    ToDoRepository td = ToDoRepository.getToDoRepository();
    List<ToDo> toDoList = null;

    public void viewByPriority() {
        toDoList = td.getToDoList();
        if(toDoList.size() > 0) {
            Collections.sort(toDoList, compareByPriority);
            printToScreen(toDoList);
        }
        else {
            System.out.println("Attenzione, la lista è vuota.");
        }
    }

    public void viewByStatus() {
        toDoList = td.getToDoList();
        if(toDoList.size() > 0) {
            Collections.sort(toDoList, compareByStatus);
            printToScreen(toDoList);
        }
        else {
            System.out.println("Attenzione, la lista è vuota.");
        }
    }

    public void viewByDate() {
        toDoList = td.getToDoList();
        if(toDoList.size() > 0) {
            Collections.sort(toDoList, compareByDate);
            printToScreen(toDoList);
        }
        else {
            System.out.println("Attenzione, la lista è vuota.");
        }
    }

    public void printToScreen(List<ToDo> toDoList) {
        for(ToDo t: toDoList) {
            System.out.println("ID: " + t.getId() );
            System.out.println("Titolo: " + t.getTitle() );
            System.out.println("Descrizione: " + t.getDescription() );
            System.out.println("Data di consegna: " + t.getDeliveryDate().toString() );
            System.out.println("Priorità: " + t.getPriority().toString() );
            System.out.println("Status: " + t.getState().toString() );
            System.out.println("\n");
        }
    }
}
