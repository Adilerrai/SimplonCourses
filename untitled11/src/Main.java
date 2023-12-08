import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        GradeManager gradeManager = new GradeManager();

        System.out.println("Welcome to the Grade Management System!");

        while (true) {
            System.out.println("\n1. Create a new student");
            System.out.println("2. Show students' grades with subject names");
            System.out.println("3. Calculate the average of all subjects");
            System.out.println("4. Calculate the average of a specific subject");
            System.out.println("5. Save to file");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    gradeManager.createStudent(scanner);
                    break;
                case 2:
                    gradeManager.showStudentsGrades();
                    break;
                case 3:
                    gradeManager.calculateAverageOfAllSubjects();
                    break;
                case 4:
                    System.out.print("Enter the subject name: ");
                    String subjectName = scanner.nextLine();
                    gradeManager.calculateAverageOfSubject(subjectName);
                    break;
                case 5:
                    gradeManager.saveToFile(gradeManager.createStudent(scanner));
                case 6:
                    System.out.println("Exiting the Grade Management System. Goodbye!");
                    System.exit(0);
            }
        }
    }
}
