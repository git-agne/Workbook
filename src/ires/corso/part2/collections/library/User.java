package ires.corso.part2.collections.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User
{
    //    - Utente (nome, cognome, id)

    private String name;
    private String surname;
    private Integer id;

    public List<Loan> loansList = new ArrayList<>();

    private static Map<Integer, List<Loan>> userLoanMap = new HashMap<>();

    public static List<Loan> getLoanById(Integer id) {
        return userLoanMap.get(id);
    }

    private static void addToMap(Integer k, Loan v) {
        List<Loan> loans;
        if(userLoanMap.containsKey(k)) {
            userLoanMap.get(k).add(v);
        }
        else {
            loans = new ArrayList<>();
            loans.add(v);
            userLoanMap.put(k, loans);
        }
    }

    public void addLoan(Loan l) {
        loansList.add(l);
        addToMap(this.id, l);
    }

    public User(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }
}
