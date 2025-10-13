package Std.api;

import Std.dto.DtoLecture;
import Std.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Lecture")
public class DtoLectureApi {
    private final LectureService lectureService;


    @GetMapping
    public ResponseEntity<?> getall(){
        return new ResponseEntity<>(lectureService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(lectureService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addDtoLecture(@RequestBody DtoLecture dtoLecture){
        lectureService.addDtoLecture(dtoLecture);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoLecture dtoLecture){
        lectureService.updateDtoLecture(id, dtoLecture);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        lectureService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
