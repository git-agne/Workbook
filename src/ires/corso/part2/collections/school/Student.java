package ires.corso.part2.collections.school;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Student
{
    //      - Student (nome, cognome, codiceStudente, tutti String)

    private final String name;
    private final String surname;
    private final String studentId;

    public List<Course> attendedCourses = new ArrayList<>();

    public Integer calculateStudentAverage(Course c) {
        List<Integer> votes = new ArrayList<>();
        for(Assignment a: c.assignmentsList) {
            for(String k: a.studentVotes.keySet()) {
                if(k.toString() == studentId) {
                    votes.add(a.studentVotes.get(k));
                }
            }
        }
        int sum = 0;
        for(Integer i: votes) {
            sum += i;
        }
        return sum / votes.size();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getStudentId() {
        return studentId;
    }

    public Student(String name, String surname, String studentId) {
        this.name = name;
        this.surname = surname;
        this.studentId = studentId;
    }
}
