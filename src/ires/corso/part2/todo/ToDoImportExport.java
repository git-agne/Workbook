package ires.corso.part2.todo;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ToDoImportExport
{
    // Gestisce import/export da file
    // Mantiene i formati di import e di export (conversione da/verso stringa)

    // Metodi statici
    // Metodo che prende come parametro un repository
    // toDoRepository(_repository) -> _repository._data e itero con iterator e
    // per ogni valore chiave, metto quel valore = al valore castato a Stringa

    private static String fileName = "to-doList.ser";

    public static ToDoRepository importFromFile() {
        ToDoRepository repo = null;
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            repo = (ToDoRepository) in.readObject();

            in.close();
            file.close();
        }
        catch(IOException | ClassNotFoundException e) {
            System.out.printf(e + " is caught");
        }
        return repo;
    }

    public static void exportToFile(ToDoRepository tdr) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(tdr);

            out.close();
            file.close();
        }
        catch(IOException e) {
            System.out.println("IOException is caught" + e);
        }
    }
}
