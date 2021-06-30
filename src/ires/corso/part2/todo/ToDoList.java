package ires.corso.part2.todo;

import java.util.ArrayList;
import java.util.List;

public class ToDoList
{
    // Implementa le funzionalità di visualizzazione con:
    // - ordinamento per priorità
    // - ordinamento per data
    // - ordinamento per stato
    // Si appoggia ai metodi di ToDoRepository per avere una lista (= copia dei TO-DO originali)
    // dei TO-DO attualmente a sistema, cioè un ArrayList facilmente utilizzabile

    ToDoRepository td = ToDoRepository.getToDoRepository();
    List<ToDo> toDoList = td.getToDoList();

    public void viewByPriority() {
        // Funzione chiamata quando l'utente vuole visualizzare

    }

    public void viewByState() {

    }

    public void viewByDate() {

    }
}
