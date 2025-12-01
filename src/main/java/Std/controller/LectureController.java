package Std.controller;

import Std.dto.DtoLecture;
import Std.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lectures")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;

    @GetMapping
    public List<DtoLecture> getAllLectures() {
        return lectureService.getAll();
    }

    @GetMapping("/{id}")
    public DtoLecture getLectureById(@PathVariable Long id) {
        return lectureService.getById(id);
    }

    @PostMapping
    public void createLecture(@RequestBody DtoLecture dtoLecture) {
        lectureService.addDtoLecture(dtoLecture);
    }

    @PutMapping("/{id}")
    public void updateLecture(@PathVariable Long id, @RequestBody DtoLecture dtoLecture) {
        lectureService.updateDtoLecture(id, dtoLecture);
    }

    @DeleteMapping("/{id}")
    public void deleteLecture(@PathVariable Long id) {
        lectureService.delete(id);
    }
}