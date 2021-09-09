package dev.patika.patikahw04.controller;

import dev.patika.patikahw04.dto.CourseDTO;
import dev.patika.patikahw04.entity.Course;
import dev.patika.patikahw04.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    // Database üzerinden gelen entityleri controller üzerinden sunmamalıyız.
    // İlgili entity içinde erişilmemesi gereken bilgileri tutuyor olabiliriz.
    // Bu nedenle DTO yapılarını kullanıyoruz
    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody @Valid CourseDTO courseDTO){
        Optional<Course> resultOptional = courseService.saveCourse(courseDTO);
        if(resultOptional.isPresent()){
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping
    public ResponseEntity<List<Course>> findAll(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable long id, @RequestBody @Valid CourseDTO courseDTO) {
        Optional<Course> courseOptional = courseService.updateCourse(courseDTO, id);
        return new ResponseEntity<>(courseOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> findCourseById(@PathVariable long courseId) {
        Course foundCourse = courseService.findCourseById(courseId);
        return new ResponseEntity<>(foundCourse, HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> deleteById(@PathVariable long courseId) {
        String result = courseService.deleteById(courseId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
