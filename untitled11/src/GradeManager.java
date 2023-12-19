import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.*;



public class GradeManager {
    private ArrayList<Student> students = new ArrayList<>();
    private Map<String, Integer> grades = new HashMap<>();


    public ArrayList<Student> createStudent(Scanner scanner) {
        // Create 
        System.out.print("Enter the student's name: ");
        String studentName = scanner.nextLine();

        Student student = new Student(studentName);

        String[] subjects = {"Math", "Physics", "Arabic", "Philosophy", "Technology"};

        for (String subjectName : subjects) {
            System.out.println("Enter scores for " + subjectName + ":");

            for (int i = 1; i <= 3; i++) {
                System.out.print("Enter score " + i + " for " + subjectName + ": ");
                int score = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                student.addGrade(subjectName, score);
            }
        }

        students.add(student);
        System.out.println("Student " + studentName + " created with scores.");
        return students;
    }


    public void showStudentsGrades() {
        System.out.println("Students' Grades:");
        for (Student student : students) {
            System.out.println("\nStudent: " + student.getName());
            System.out.println("Grades:");
            for (Map.Entry<String, Integer> entry : student.getGrades().entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public void calculateAverageOfAllSubjects() {
        double totalAverage = 0;
        int totalSubjects = 0;

        for (Student student : students) {
            for (int grade : student.getGrades().values()) {
                totalAverage += grade;
                totalSubjects++;
            }
        }

        if (totalSubjects > 0) {
            double average = totalAverage / totalSubjects;
            System.out.println("Average of all subjects: " + average);
        } else {
            System.out.println("No subjects found to calculate the average.");
        }
    }

    public void calculateAverageOfSubject(String subjectName) {
        double total = 0;
        int count = 0;

        for (Student student : students) {
            if (student.getGrades().containsKey(subjectName)) {
                total += student.getGrades().get(subjectName);
                count++;
            }
        }

        if (count > 0) {
            double average = total / count;
            System.out.println("Average of " + subjectName + ": " + average);
        } else {
            System.out.println("No grades found for " + subjectName);
        }
    }
}
//    public void saveToFile (ArrayList<Student> students) throws IOException {
//
//
//            File file = new File("file.csv");
//
//            BufferedWriter bf = null;
//
//            try {
//
//                bf = new BufferedWriter(new FileWriter(file));
//
//                for (grades.Entry<String, Integer> entry :
//                        grades.entrySet()) {
//
//                    bf.write(entry.getKey() + ":"
//                            + entry.getValue());
//                    bf.newLine();
//                }
//
//                bf.flush();
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//            finally {
//
//                try {
//                    bf.close();
//                }
//                catch (Exception e) {
//                }
//            }
//        }
//    }
