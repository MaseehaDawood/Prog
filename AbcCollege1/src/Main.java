import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String choice = scanner.nextLine();
            if (!"1".equals(choice)) {
                break;
            }

            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture new student");
            System.out.println("(2) Search for student");
            System.out.println("(3) Delete a student");
            System.out.println("(4) Print student report");
            System.out.println("(5) Exit Application");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    captureNewStudent(management, scanner);
                    break;
                case "2":
                    searchForStudent(management, scanner);
                    break;
                case "3":
                    deleteStudent(management, scanner);
                    break;
                case "4":
                    management.printStudentReport();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void captureNewStudent(StudentManagement management, Scanner scanner) {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.print("Enter the student id: ");
        String id = scanner.nextLine();
        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Enter the student age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 16) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect student age!!! Please re-enter the student age.");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect student age!!! Please re-enter the student age.");
            }
        }

        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, email, course);
        management.saveStudent(student);
    }

    private static void searchForStudent(StudentManagement management, Scanner scanner) {
        System.out.print("Enter the student id to search: ");
        String id = scanner.nextLine();
        Student student = management.searchStudent(id);

        if (student != null) {
            System.out.println("STUDENT ID: " + student.getStudentId());
            System.out.println("STUDENT NAME: " + student.getName());
            System.out.println("STUDENT AGE: " + student.getAge());
            System.out.println("STUDENT EMAIL: " + student.getEmail());
            System.out.println("STUDENT COURSE: " + student.getCourse());
        } else {
            System.out.println("Student with Student Id: " + id + " was not found!");
        }
    }

    private static void deleteStudent(StudentManagement management, Scanner scanner) {
        System.out.print("Enter the student id to delete: ");
        String id = scanner.nextLine();
        if (management.deleteStudent(id)) {
            System.out.println("Student with Student Id: " + id + " has been deleted!");
        } else {
            System.out.println("Student with Student Id: " + id + " was not found!");
        }
    }
}

