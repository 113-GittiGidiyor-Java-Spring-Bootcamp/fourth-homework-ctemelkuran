package dev.patika.patikahw04.controller;

import dev.patika.patikahw04.dto.CourseDTO;
import dev.patika.patikahw04.entity.Course;
import dev.patika.patikahw04.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Database üzerinden gelen entityleri controller üzerinden sunmamalıyız.
    // İlgili entity içinde erişilmemesi gereken bilgileri tutuyor olabiliriz.
    // Bu nedenle DTO yapılarını kullanıyoruz
    @PostMapping("/save-course")
    public ResponseEntity<Course> saveCourse(@RequestBody @Valid CourseDTO courseDTO){
        Optional<Course> resultOptional = courseService.saveCourse(courseDTO);
        if(resultOptional.isPresent()){
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
