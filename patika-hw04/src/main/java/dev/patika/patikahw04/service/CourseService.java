package dev.patika.patikahw04.service;

import dev.patika.patikahw04.dto.CourseDTO;
import dev.patika.patikahw04.entity.Course;
import dev.patika.patikahw04.entity.Student;
import dev.patika.patikahw04.exceptions.CourseIsAlreadyExistException;
import dev.patika.patikahw04.exceptions.StudentNumberForOneCourseExceededException;
import dev.patika.patikahw04.mappers.CourseMapper;
import dev.patika.patikahw04.repository.CourseRepository;
import dev.patika.patikahw04.repository.StudentRepository;
import dev.patika.patikahw04.util.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final CourseMapper courseMapper;

    /** Method to show all entities
     *
     * @return all entities found as a List.
     */
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> courseIterable = courseRepository.findAll();
        courseIterable.iterator().forEachRemaining(courseList::add);
        return courseList;

    }

    /**
     * @param courseDTO takes Data Transfer Object as parameter
     * @return saved Course object returned
     */
    @Transactional
    public Optional<Course> saveCourse(CourseDTO courseDTO) {
        // received data can be checked in the method
        // check if the course with the given courseCode exists
        boolean isCourseCodeExists = courseRepository.selectExistsCourseCode(courseDTO.getCourseCode());

        if (isCourseCodeExists) {
            throw new CourseIsAlreadyExistException(ErrorMessageConstants.COURSE_EXISTS + courseDTO.getCourseCode());
        }

        Course course = courseMapper.mapFromCourseDTOtoCourse(courseDTO);

        return Optional.of(courseRepository.save(course));
    }


    /** Used to update
     * Mapper is called to convert DTO to entity object
     *
     * @param courseDTO
     * @return Optional Course
     */
    @Transactional
    public Optional<Course> updateCourse(CourseDTO courseDTO, long courseId) {
        courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (courseDTO.getEnrolledStudentIds().size() > 20){
            throw new StudentNumberForOneCourseExceededException("Maximum 20 students can enroll a course.");
        }

        Course course = courseMapper.mapFromCourseDTOtoCourse(courseDTO);
        return Optional.of(courseRepository.save(course));
    }

    /** Find required entity by Id
     *
     * @param courseId
     * @return found entity
     */
    public Course findCourseById(long courseId) {
        Course foundCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return foundCourse;
    }


    /**
     * Deletes the object with given id
     *
     * @param courseId
     * @return
     */
    @Transactional
    public String deleteById(long courseId) {

        Course foundCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        courseRepository.delete(foundCourse);
        return "Course deleted with id: " + courseId;
    }
}
