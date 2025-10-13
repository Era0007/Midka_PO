package Std.api;


import Std.dto.DtoStudent;
import Std.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Dto")
public class DtoStudentApi {
    private final StudentService service;


    @GetMapping
    public ResponseEntity<?> getAll(){
        return  new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addDto(@RequestBody DtoStudent dtoStudent){
        service.addDto(dtoStudent);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping({"/id"})
    public ResponseEntity<?> updateDto(@RequestBody DtoStudent dtoStudent, @PathVariable("id") Long id){
        service.updateDto(id, dtoStudent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.deleteDto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
