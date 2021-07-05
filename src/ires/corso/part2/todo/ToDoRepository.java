package ires.corso.part2.todo;

import java.io.*;
import java.util.*;

public class ToDoRepository implements Serializable
{
    // GESTORE DELL'ARCHIVIO DEI TO-DO == DATABASE

    // Contiene una HashMap di tutti i TO-DO a sistema:
    // - implementa il metodo di salvataggio su file
    // - implementa il metodo di caricamento da file
    // - metodi per individuare, aggiungere, eliminare un TO-DO
    // - restituisce una copia di tutti i TO-DO come ArrayList, da usare per le visualizzazioni

    private long idSeed;
    Map<Long, ToDo> _data = new HashMap<>();

    private static ToDoRepository _repository = null;

    public static void writeToFile() throws IOException {
        ToDoImportExport.exportToFile(_repository);
    }

    public static void loadFromFile() throws IOException {
       _repository = ToDoImportExport.importFromFile();
    }

    public long getNewId() {
        idSeed ++;
        return idSeed;
    }

    public ToDo getToDoByID(int id) {
        return _data.get(id);
    }

    public void delete(Long ID) {
        _data.remove(ID);
    }

    public void add(ToDo t) {
        t.setId(getNewId());
        _data.put(t.getId(), t);
    }

    public void update(ToDo t) {
        Set<Long> sl = _data.keySet();
        Iterator<Long> longIter = sl.iterator();

        while(longIter.hasNext()) {
            if(longIter.next() == t.getId()) {
                _data.put(t.getId(), t);
            }
            else {
                System.out.println("Il To-Do non esiste.");
            }
        }

        // 1. t è una copia di un To-Do, contiene tutte le modifiche fatte campo per campo
        // t sovrascrive la sua versione precedente nella collection con add()
        // 2. si prende Id di t e si verifica se esiste un To-Do corrispondente
        // con remove/put si sostituisce t alla sua versione precedente
    }

    public List<ToDo> getToDoList() {
        ArrayList<ToDo> todoList = new ArrayList<>();

        for(ToDo t: _data.values()) {
            todoList.add(t);
        }
        return todoList;
    }

    private ToDoRepository() {}

    public static ToDoRepository getToDoRepository() {
        if(_repository == null) {
            _repository = new ToDoRepository();
        }
        return _repository;
    }
}
