package ires.corso.part2.todo;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ToDoList
{
    Comparator<ToDo> compareByPriority = (ToDo t1, ToDo t2) -> t1.getPriority().compareTo(t2.getPriority());

    Comparator<ToDo> compareByStatus = (ToDo t1, ToDo t2) -> t1.getState().compareTo(t2.getState());

    Comparator<ToDo> compareByDate = (ToDo t1, ToDo t2) -> t1.getDeliveryDate().compareTo(t2.getDeliveryDate());

    public ToDoList() throws IOException {
    }

    public void viewByPriority() {
        List<ToDo> toDoList = getUpdatedList();
        if(toDoList.size() > 0) {
            Collections.sort(toDoList, compareByPriority);
            printToScreen(toDoList);
        }
        else {
            System.out.println("Attenzione, la lista è vuota.");
        }
    }

    public void viewByStatus() {
        List<ToDo> toDoList = getUpdatedList();
        if(toDoList.size() > 0) {
            Collections.sort(toDoList, compareByStatus);
            printToScreen(toDoList);
        }
        else {
            System.out.println("Attenzione, la lista è vuota.");
       }
    }

    public void viewByDate() {
        List<ToDo> toDoList = getUpdatedList();
        if(toDoList.size() > 0) {
            Collections.sort(toDoList, compareByDate);
            printToScreen(toDoList);
        }
        else {
            System.out.println("Attenzione, la lista è vuota.");
        }
    }

    public List<ToDo> getUpdatedList() {
        ToDoRepository td = ToDoRepository.getToDoRepository();
        List<ToDo> toDoList = td.getToDoList();
        return toDoList;
    }

    public void printToScreen(List<ToDo> toDoList) {
        for(ToDo t: toDoList) {
            System.out.println("\n");
            System.out.println("ID: " + t.getId() );
            System.out.println("Titolo: " + t.getTitle() );
            System.out.println("Descrizione: " + t.getDescription() );
            System.out.println("Data di consegna: " + t.getDeliveryDate().toString() );
            System.out.println("Priorità: " + t.getPriority().toString() );
            System.out.println("Status: " + t.getState().toString() );
        }
    }
}
