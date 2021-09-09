package dev.patika.patikahw04.controller;

import dev.patika.patikahw04.dto.InstructorDTO;
import dev.patika.patikahw04.entity.Instructor;
import dev.patika.patikahw04.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;


    @PostMapping
    public ResponseEntity<Instructor> saveInstructor(@RequestBody @Valid InstructorDTO instructorDTO){
        Optional<Instructor> resultOptional = instructorService.saveInstructor(instructorDTO);
        if(resultOptional.isPresent()){
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> findAll(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable long id, @RequestBody @Valid InstructorDTO instructorDTO) {
        Optional<Instructor> instructorOptional = instructorService.updateInstructor(instructorDTO, id);
        return new ResponseEntity<>(instructorOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/{instructorId}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable long instructorId) {
        Instructor foundInstructor = instructorService.findInstructorById(instructorId);
        return new ResponseEntity<>(foundInstructor, HttpStatus.OK);
    }

    @DeleteMapping("/{instructorId}")
    public ResponseEntity<?> deleteById(@PathVariable long instructorId) {
        String result = instructorService.deleteById(instructorId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

