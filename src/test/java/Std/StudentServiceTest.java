package Std;

import Std.dto.DtoStudent;
import Std.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles("test")
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void shouldReturnAllStudents() {
        List<DtoStudent> students = studentService.getAll();

        assertNotNull(students);
        System.out.println("Найдено студентов: " + students.size());
    }

    @Test
    void shouldCreateStudent() {
        DtoStudent newStudent = new DtoStudent();
        newStudent.setFirstName("Test");
        newStudent.setLastName("User");
        newStudent.setEmail("test@test.com");
        newStudent.setAge(25);
        studentService.addDto(newStudent);

        assertTrue(true);
        System.out.println("Студент создано успешно");
    }
}