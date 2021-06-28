package ires.corso.part2.collections.school;

import java.util.*;

public class Course
{
    //    - Course (titolo, descrizione, settore)

    private final String title;
    private final String description;
    private final String sector;

    public List<Assignment> assignmentsList = new ArrayList<>();
    public List<Student> studentList = new ArrayList<>();

    public Map<Student, List<Assignment>> studentAssignmentMap = new HashMap<>();

    public Integer calculateCourseAverage() {
        List<Integer> votes = new ArrayList<>();
        Iterator<String> intIter;
        for(Assignment a: assignmentsList) {
            intIter = a.studentVotes.keySet().iterator();
            while(intIter.hasNext()) {
                votes.add(a.studentVotes.get(intIter.next()));
            }
        }
        Integer sum = 0;
        for(Integer v: votes) {
            System.out.println(v.toString());
            sum += v;
        }
        return sum / votes.size();
    }

    public void createStudentMap() {
        for(Student st: studentList) {
            studentAssignmentMap.put(st, assignmentsList);
        }
    }

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public void addAssignment(Assignment a) {
        assignmentsList.add(a);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSector() {
        return sector;
    }

    public Course(String title, String description, String sector) {
        this.title = title;
        this.description = description;
        this.sector = sector;
    }
}
