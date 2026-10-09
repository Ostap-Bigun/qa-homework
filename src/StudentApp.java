import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StudentApp {
    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        students.add(new Student(
                "Ivanov Ivan",
                "QA",
                1,
                List.of(5, 2, 3, 4)
        ));

        students.add(new Student(
                "Ivanov Bogdan",
                "QC",
                3,
                List.of(2, 2, 3, 2)
        ));

        students.add(new Student(
                "Bratanov Kolgan",
                "QA",
                2,
                List.of(5, 5, 5, 4)
        ));

        printStudents(students, 3);
        removeBadStudents((students));
        promoteStudents(students);
        printStudents(students, 3);
    }

    static void removeBadStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.avgGrade() < 3) {
                iterator.remove();
            }
        }
    }

    static void promoteStudents(Set<Student> students){
        for (Student student : students){
            if (student.avgGrade()>=3) {
                student.course++;
            }
        }
    }

    static void printStudents(Set<Student> students, int course){
        for (Student student:students){
            if (student.course == course){
                System.out.println("Имя: " + student.name);
                System.out.println("Курс №: " + student.course);
            }
        }
    }

}
