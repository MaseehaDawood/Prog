import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private List<Student> students = new ArrayList<>();

    public void saveStudent(Student student) {
        students.add(student);
        System.out.println("Student details have been successfully saved.");
    }

    public Student searchStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public boolean deleteStudent(String studentId) {
        Student student = searchStudent(studentId);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }

    public void printStudentReport() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println("STUDENT ID: " + student.getStudentId());
                System.out.println("STUDENT NAME: " + student.getName());
                System.out.println("STUDENT AGE: " + student.getAge());
                System.out.println("STUDENT EMAIL: " + student.getEmail());
                System.out.println("STUDENT COURSE: " + student.getCourse());
                System.out.println();
            }
        }
    }
}

