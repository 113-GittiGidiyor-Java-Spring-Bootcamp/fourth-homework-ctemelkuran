package dev.patika.patikahw04.controller;

import dev.patika.patikahw04.dto.InstructorDTO;
import dev.patika.patikahw04.entity.Instructor;
import dev.patika.patikahw04.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @PostMapping("/save-instructor")
    public ResponseEntity<Instructor> saveInstructor(@RequestBody @Valid InstructorDTO instructorDTO){
        Optional<Instructor> resultOptional = instructorService.saveInstructor(instructorDTO);
        if(resultOptional.isPresent()){
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}

