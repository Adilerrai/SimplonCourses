
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private Map<String, Integer> grades = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }

    public void addGrade(String subject, int grade) {
        grades.put(subject, grade);
    }
    public int getSize(){
        return grades.size();
    }

}
