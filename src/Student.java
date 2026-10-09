import java.util.List;

public class Student {
    String name;
    String group;
    int course;
    List<Integer> grades;

    Student(String name, String group, int course, List<Integer> grades){
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    double avgGrade(){
        double avg = 0;
        double sum = 0;
        for (int i = 0; i<grades.size(); i++){
            sum = sum + grades.get(i);
        }
        avg = sum/grades.size();
        return avg;
    }

}
