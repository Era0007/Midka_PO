package Std;

import Std.dto.DtoStudent;
import Std.model.Student;
import Std.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class StudentMapperTest {

    @Autowired
    private StudentService studentService;

    @Test
    void shouldConvertEntityToDto() {
        Student entity = new Student();
        entity.setId(1L);
        entity.setFirstname("John");
        entity.setLastname("Smith");
        entity.setAge(20);
        entity.setEmail("john@email.com");

        DtoStudent dto = studentService.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getFirstname(), dto.getFirstName());
        Assertions.assertEquals(entity.getLastname(), dto.getLastName());
        Assertions.assertEquals(entity.getAge(), dto.getAge());
        Assertions.assertEquals(entity.getEmail(), dto.getEmail());
    }

    @Test
    void shouldConvertDtoToEntity() {
        DtoStudent dto = new DtoStudent();
        dto.setId(1L);
        dto.setFirstName("Era");
        dto.setLastName("ZZZ");
        dto.setAge(22);
        dto.setEmail("era@email.com");

        Student entity = studentService.toStudent(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getFirstName(), entity.getFirstname());
        Assertions.assertEquals(dto.getLastName(), entity.getLastname());
        Assertions.assertEquals(dto.getAge(), entity.getAge());
        Assertions.assertEquals(dto.getEmail(), entity.getEmail());
    }

    @Test
    void shouldHandleNullValues() {
        DtoStudent dto = new DtoStudent();
        dto.setFirstName(null);
        dto.setLastName(null);
        Student entity = studentService.toStudent(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertNull(entity.getFirstname());
        Assertions.assertNull(entity.getLastname());
    }
}