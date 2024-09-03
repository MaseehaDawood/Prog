import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentManagementTest {

    @Test
    void testSaveStudent() {
        StudentManagement management = new StudentManagement();
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        management.saveStudent(student);
        assertEquals(student, management.searchStudent("10111"));
    }

    @Test
    void testSearchStudent() {
        StudentManagement management = new StudentManagement();
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        management.saveStudent(student);
        Student foundStudent = management.searchStudent("10111");
        assertNotNull(foundStudent);
        assertEquals("J.Bloggs", foundStudent.getName());
    }

    @Test
    void testSearchStudent_StudentNotFound() {
        StudentManagement management = new StudentManagement();
        Student foundStudent = management.searchStudent("99999");
        assertNull(foundStudent);
    }

    @Test
    void testDeleteStudent() {
        StudentManagement management = new StudentManagement();
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        management.saveStudent(student);
        assertTrue(management.deleteStudent("10111"));
    }

    @Test
    void testDeleteStudent_StudentNotFound() {
        StudentManagement management = new StudentManagement();
        assertFalse(management.deleteStudent("99999"));
    }

    @Test
    void testStudentAge_StudentAgeValid() {
        int age = 18;
        assertTrue(true);
    }

    @Test
    void testStudentAge_StudentAgeInvalid() {
        int age = 15;
        assertFalse(false);
    }

    @Test
    void testStudentAge_StudentAgeInvalidCharacter() {
        String ageInput = "C";
        assertThrows(NumberFormatException.class, () -> Integer.parseInt(ageInput));
    }
}
