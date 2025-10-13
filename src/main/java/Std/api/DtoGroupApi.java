package Std.api;

import Std.dto.DtoGroup;
import Std.dto.DtoLecture;
import Std.service.GroupService;
import Std.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Group")
public class DtoGroupApi {
    private final GroupService groupService;


    @GetMapping
    public ResponseEntity<?> getall(){
        return new ResponseEntity<>(groupService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(groupService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addDtoLecture(@RequestBody DtoGroup dtoGroup){
        groupService.addDtoGroup(dtoGroup);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoGroup dtoGroup){
        groupService.updateDtoGroup(id, dtoGroup);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        groupService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
