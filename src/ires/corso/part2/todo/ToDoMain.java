package ires.corso.part2.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoMain {
    public static void main(String[] args) {
        ToDo td = new ToDo("Spesa", "xx", LocalDate.of(2021, 06, 30), LocalDate.of(2022, 06,30));
        ToDo td1 = new ToDo("Spesa", "xx", LocalDate.of(2021, 06, 30), LocalDate.of(2022, 06,30));

        ToDoRepository tdr = new ToDoRepository();
        tdr.add(td);
        tdr.add(td1);

        List<ToDo> tdList = tdr.getToDoList();

        for(ToDo t: tdList) {
            System.out.println(t.getId());
        }
    }
}
