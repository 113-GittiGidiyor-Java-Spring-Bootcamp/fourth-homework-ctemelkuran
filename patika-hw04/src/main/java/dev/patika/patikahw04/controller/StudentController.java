package dev.patika.patikahw04.controller;

import dev.patika.patikahw04.dto.StudentDTO;
import dev.patika.patikahw04.entity.Student;
import dev.patika.patikahw04.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // Database üzerinden gelen entityleri controller üzerinden sunmamalıyız.
    // İlgili entity içinde erişilmemesi gereken bilgileri tutuyor olabiliriz.
    // Bu nedenle DTO yapılarını kullanıyoruz
    /** Method to save the entity with given DTO.
     *
     * @param studentDTO
     * @return ResponseEntity<>
     */
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody @Valid StudentDTO studentDTO){
        Optional<Student> resultOptional = studentService.saveStudent(studentDTO);
        if(resultOptional.isPresent()){
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody @Valid StudentDTO studentDTO) {
        Optional<Student> studentOptional = studentService.updateStudent(studentDTO, id);
        return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> findStudentById(@PathVariable long studentId) {
        Student foundStudent = studentService.findStudentById(studentId);
        return new ResponseEntity<>(foundStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteById(@PathVariable long studentId) {
        String result = studentService.deleteById(studentId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
