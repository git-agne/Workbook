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

    private static String fileName = "to-doList.txt";

    Map<Long, ToDo> _data = new HashMap<>();

    // Serializzazione con la funzione writeObject()
    // Chiamando writeObject() serializza l'oggetto non appena il metodo viene chiamato
    private static ToDoRepository _repository = null;

    public static void writeToFile() throws IOException {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // new ToDoImportExport
            // _repository = al metodo toDoRepository(_repository) di import/export
            out.writeObject(_repository);

            out.close();
            file.close();
        }
        catch(IOException e) {
            System.out.println("IOException is caught");
        }
    }

    public static ToDoRepository loadFromFile() throws IOException {
        // Individua il file e lo deserializza con readObject
        // _repository = ...

        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            _repository = (ToDoRepository) in.readObject();

            in.close();
            file.close();
        }
        catch(IOException | ClassNotFoundException e) {
            System.out.printf(e + " is caught");
        }

        return _repository;
    }

    public void delete(Long ID) {
        _data.remove(ID);
    }

    public void add(ToDo t) {
        // Si deve entrare nell'oggetto t e leggere il suo ID
        // per poi salvarlo nella mappa correttamente (con put(ID, t))
        _data.put(t.getId(), t);
    }

    public void update(ToDo t) {
        // Si prende ID dall'oggetto t
        // Si recupera dalla mappa il TO-DO corrispondente con get(t), per controllo
        // Si sostituisce con put(ID, t)

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
    }

    public List<ToDo> getToDoList() {
        // Restituisce lista di tutti i TO-DO esistenti

        ArrayList<ToDo> todoList = new ArrayList<>(_data.values());
        return todoList;
    }

    public static ToDoRepository getToDoRepository() {
        return _repository;
    }

}
