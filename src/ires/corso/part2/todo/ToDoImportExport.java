package ires.corso.part2.todo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class ToDoImportExport
{
    private static String outputFileName = "to-doListOutput.txt";
    private static String inputFileName = "to-doListInput.txt";

    private static String convertToString(ToDo t) {
        String tdString = String.format("%s|%s|%s|%s|%s|%s", t.getTitle(), t.getDescription(),
                t.getInsertionDate().toString(), t.getDeliveryDate().toString(), t.getPriority().toString(), t.getState().toString());
        return tdString;
    }

    private static ToDo convertFromString(String[] arrStr) throws Exception {
        if(arrStr.length != 5) {
            throw new Exception("L'Array non è accettabile.");
        }

        String title = null;
        String description = null;
        LocalDate creationDate = LocalDate.now();
        LocalDate expirationDate = null;
        ToDo.Priority priority = null;
        ToDo.State status = null;

        if(arrStr[0] != null) {
            title = arrStr[0];
        }
        else {
            System.out.println("Titolo nullo.");
        }

        if(arrStr[1] != null) {
            description = arrStr[1];
        }
        else {
            System.out.println("Descrizione nulla.");
        }

        if(arrStr[2] != null) {
            expirationDate = LocalDate.parse(arrStr[2].toString());
        }
        else {
            System.out.println("Data  nulla.");
        }

        if(arrStr[3].equals("ALTA")) {
            priority = ToDo.Priority.ALTA;
        }
        else if(arrStr[3].equals("MEDIA")) {
            priority = ToDo.Priority.MEDIA;
        }
        else if(arrStr[3].equals("BASSA")) {
            priority = ToDo.Priority.BASSA;
        }
        else {
            System.out.println("Priorità nulla.");
        }

        if(arrStr[4].equals("DA_FARE")) {
            status = ToDo.State.DA_FARE;
        }
        else if(arrStr[4].equals("IN_ESECUZIONE")) {
            status = ToDo.State.IN_ESECUZIONE;
        }
        else if(arrStr[4].equals("COMPLETATA")) {
            status = ToDo.State.COMPLETATA;
        }
        else if(arrStr[4].equals("ANNULLATA")) {
            status = ToDo.State.ANNULLATA;
        }
        else {
            System.out.println("Stato nullo.");
        }

        ToDo td = new ToDo(title, description, creationDate, expirationDate, priority, status);
        return td;
    }

    // Non posso salvare id e data creazione
    public static void importFromFile() throws Exception {
        ArrayList<String> stringLines = new ArrayList<>();

        try(BufferedReader inputStream = new BufferedReader(new FileReader(inputFileName))) {
            String s;
            while((s = inputStream.readLine()) != null) {
                stringLines.add(s);
            }
        }

        Iterator<String> stringIter = stringLines.iterator();
        while(stringIter.hasNext()) {
            String line = stringIter.next();
            String[] splittedStrings = line.split("\\|");

            ToDo t = convertFromString(splittedStrings);

            ToDoRepository.getToDoRepository().add(t);
        }
        System.out.println("Lista importata.");
    }

    public static void exportToFile() throws IOException {
        try(PrintWriter output = new PrintWriter(new FileWriter(outputFileName))) {
            ArrayList<ToDo> tdList = ToDoRepository.getToDoRepository().getToDoList();
            Iterator<ToDo> tdIter = tdList.iterator();

            while(tdIter.hasNext()) {
                // Salvo in stringa, e poi salvo stringa nello stream/file
                String tdString = convertToString(tdIter.next());
                output.println(tdString);
            }
        }
        System.out.println("Lista esportata.");
    }
}
