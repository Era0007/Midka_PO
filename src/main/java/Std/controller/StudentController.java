package Std.controller;

import Std.dto.DtoStudent;
import Std.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<DtoStudent> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public DtoStudent getStudentById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @GetMapping("/search")
    public List<DtoStudent> searchStudents(
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname,
            @RequestParam(required = false) Integer age) {

        return studentService.searchStudents(firstname, lastname, age);
    }

    @PostMapping
    public void createStudent(@RequestBody DtoStudent dtoStudent) {
        studentService.addDto(dtoStudent);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody DtoStudent dtoStudent) {
        studentService.updateDto(id, dtoStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteDto(id);
    }
}