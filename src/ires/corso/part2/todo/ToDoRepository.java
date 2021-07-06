package ires.corso.part2.todo;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class ToDoRepository implements Serializable
{
    private long idSeed;
    Map<Long, ToDo> _data = new HashMap<>();
    private static String fileName = "to-doList.ser";

    public static ToDoRepository _repository = null;

    public static void writeToFile() {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(_repository);

            out.close();
            file.close();
        }
        catch(IOException e) {
            System.out.println(e + " is caught.");
        }
    }

    public static void loadFromFile() {
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            _repository = (ToDoRepository) in.readObject();

            in.close();
            file.close();
        }
        catch(IOException | ClassNotFoundException e) {
            System.out.printf(e + " is caught.");
        }
    }

    public long getNewId() {
        idSeed ++;
        return idSeed;
    }

    public ToDo getToDoByID(Long id) {
        return _data.get(id);
    }

    public void delete(Long ID) {
        _data.remove(ID);
        writeToFile();
    }

    public void add(ToDo t) {
        t.setId(getNewId());
        _data.put(t.getId(), t);
        writeToFile();
    }

    public void update(ToDo t) {
        Set<Long> sl = _data.keySet();
        Iterator<Long> longIter = sl.iterator();

        while(longIter.hasNext()) {
            if(longIter.next().longValue() == t.getId()) {
                _data.put(t.getId(), t);
                writeToFile();
                System.out.println("Modifica accettata.");
                break;
            }
            else {
                System.out.println("Il To-Do non esiste.");
            }
        }
    }

    public ArrayList<ToDo> getToDoList() {
        ArrayList<ToDo> todoList = new ArrayList<>();

        for(ToDo t: _data.values()) {
            todoList.add(t);
        }
        return todoList;
    }

    public static ToDoRepository getToDoRepository() {
        if(_repository == null) {
            _repository = new ToDoRepository();
        }
        if(!Paths.get(fileName).toFile().exists()){
            writeToFile();
            loadFromFile();
        } else {
            loadFromFile();
        }
        return _repository;
    }
}
