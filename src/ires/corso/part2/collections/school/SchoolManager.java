package ires.corso.part2.collections.school;

import java.util.Iterator;

public class SchoolManager
{
    //    Create anche i dati di almeno:
    //    - 3 studenti
    //    - 3 corsi
    //    - Un corso ha 2 o + assignment, ciascun studente esegue tutti gli assignment e riceve un voto da 1 a 10.
    //
    //    Caricate tutti i dati in un'unica collection, organizzata in modo da poter contenere tutti i voti presi
    //    da ciascuno studente. (Map<Student, List<vote> ??)
    //
    //    Calcolate con questa struttura:
    //    - la media dei voti di ciascun studente in ciascun corso (come è andato ciascun studente in un corso?)
    //    - la media dei voti di tutti gli studenti in ciascun assignment (quanto è difficile per gli studenti un certo assignment?)

    public static void main(String[] args) {
        Student s1 = new Student("Mario", "Rossi", "123");
        Student s2 = new Student("Michela", "Bianchi", "456");
        Student s3 = new Student("Elena", "Verdi", "789");

        Course c1 = new Course("Italiano", "Letteratura italiana", "Letteratura");
        Course c2 = new Course("Biologia", "Biologia umana", "Scienze naturali");
        Course c3 = new Course("Latino", "Traduzioni", "Lingue antiche");

        Assignment a1 = new Assignment("Tema", "Tema di italiano");
        Assignment a2 = new Assignment("Parafrasi", "Parafrasi della poesia");
        Assignment a3 = new Assignment("Test", "Test di biologia");
        Assignment a4 = new Assignment("Versione", "Traduzione dal latino");
        Assignment a5 = new Assignment("Test latino", "Traduzione dall'italiano");

        c1.addAssignment(a1);
        c1.addAssignment(a2);
        c2.addAssignment(a3);
        c3.addAssignment(a4);
        c3.addAssignment(a5);

        c1.addStudent(s1);
        c1.addStudent(s2);
        c1.addStudent(s3);
        c2.addStudent(s1);
        c2.addStudent(s2);
        c2.addStudent(s3);
        c3.addStudent(s1);
        c3.addStudent(s2);
        c3.addStudent(s3);

        c1.createStudentMap();
        c2.createStudentMap();
        c3.createStudentMap();

        // Iteriamo sugli Student, ogni Student farà gli Assignment e gli viene assegnato un voto
        for(Student s: c1.studentList) {
            for(Assignment a: c1.assignmentsList) {
                a.doAssignment(s.getStudentId());
            }
        }

        System.out.println("La media del corso è " + c1.calculateCourseAverage().toString());
        System.out.println("La media dello studente è " + s1.calculateStudentAverage(c1).toString());
        System.out.println("La media dello studente è " + s2.calculateStudentAverage(c1).toString());
        System.out.println("La media dello studente è " + s3.calculateStudentAverage(c1).toString());
    }
}
