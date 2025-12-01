package Std;

import Std.dto.DtoLecture;
import Std.service.LectureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles("test")
public class LectureServiceTest {

    @Autowired
    private LectureService groupService;

    @Test
    void shouldReturnAllGroups() {
        List<DtoLecture> groups = groupService.getAll();
        assertNotNull(groups);
        System.out.println("Найдено групп: " + groups.size());
    }
}