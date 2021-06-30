package ires.corso.part2.todo;

import java.time.LocalDate;

public class ToDoListManager
{
    // Classe ToDoList ??

    public static void main(String[] args) {
        /*
        Menu m = new Menu();

        m.printMenu();

         */

        ToDo td1 = new ToDo("Spesa", "xx", LocalDate.of(2021, 6, 06), LocalDate.of(2022, 9, 10));
        ToDo td3 = new ToDo("Spesa", "xx", LocalDate.of(2020, 6, 06), LocalDate.of(2022, 9, 10));
        //ToDo td2 = td1.cloneForUpdate();

        System.out.println(td1.getId().toString());
        System.out.println(td3.getId().toString());
    }
}
