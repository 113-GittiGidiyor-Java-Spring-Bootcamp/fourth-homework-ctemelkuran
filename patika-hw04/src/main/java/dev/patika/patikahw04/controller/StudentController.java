package dev.patika.patikahw04.controller;

import dev.patika.patikahw04.dto.StudentDTO;
import dev.patika.patikahw04.entity.Student;
import dev.patika.patikahw04.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Database üzerinden gelen entityleri controller üzerinden sunmamalıyız.
    // İlgili entity içinde erişilmemesi gereken bilgileri tutuyor olabiliriz.
    // Bu nedenle DTO yapılarını kullanıyoruz
    /** Method to save the entity with given DTO.
     *
     * @param studentDTO
     * @return ResponseEntity<>
     */
    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody @Valid StudentDTO studentDTO){
        Optional<Student> resultOptional = studentService.saveStudent(studentDTO);
        if(resultOptional.isPresent()){
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
