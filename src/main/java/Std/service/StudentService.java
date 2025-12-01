package Std.service;

import Std.dto.DtoStudent;
import Std.model.Student;
import Std.repos.StudentRepos;
import Std.repos.StudentCriteriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepos studentRepos;
    private final StudentCriteriaRepository studentCriteriaRepository;

    public List<DtoStudent> getAll(){
        List<Student> students = studentRepos.findAll();
        List<DtoStudent> dtoStudents = new ArrayList<>();

        for(Student s : students){
            dtoStudents.add(toDto(s));
        }
        return dtoStudents;
    }

    public DtoStudent getById(Long id){
        return toDto(studentRepos.getById(id));
    }

    public void addDto(DtoStudent dtoStudent){
        Student student = toStudent(dtoStudent);
        studentRepos.save(student);
    }

    public void updateDto(Long id, DtoStudent dtoStudent){
        Student student = studentRepos.getById(id);
        student = toStudent(dtoStudent);
        studentRepos.save(student);
    }

    public void deleteDto(Long id){
        studentRepos.deleteById(id);
    }

    public List<DtoStudent> searchStudents(String firstname, String lastname, Integer age) {
        List<Student> students = studentCriteriaRepository.findStudents(firstname, lastname, age);
        List<DtoStudent> dtoStudents = new ArrayList<>();

        for(Student s : students){
            dtoStudents.add(toDto(s));
        }
        return dtoStudents;
    }

    public DtoStudent toDto(Student student){
        DtoStudent dtoStudent = new DtoStudent();

        dtoStudent.setId(student.getId());
        dtoStudent.setFirstName(student.getFirstname());
        dtoStudent.setLastName(student.getLastname());
        dtoStudent.setAge(student.getAge());
        dtoStudent.setEmail(student.getEmail());

        return dtoStudent;
    }

    public Student toStudent(DtoStudent dtoStudent){
        Student student = new Student();

        student.setFirstname(dtoStudent.getFirstName());
        student.setLastname(dtoStudent.getLastName());
        student.setAge(dtoStudent.getAge());
        student.setId(dtoStudent.getId());
        student.setEmail(dtoStudent.getEmail());

        return student;
    }
}