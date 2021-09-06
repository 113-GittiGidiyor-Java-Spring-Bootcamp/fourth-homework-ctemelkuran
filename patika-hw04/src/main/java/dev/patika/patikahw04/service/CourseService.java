package dev.patika.patikahw04.service;

import dev.patika.patikahw04.dto.CourseDTO;
import dev.patika.patikahw04.entity.Course;
import dev.patika.patikahw04.exceptions.CourseIsAlreadyExistException;
import dev.patika.patikahw04.mappers.CourseMapper;
import dev.patika.patikahw04.repository.CourseRepository;
import dev.patika.patikahw04.util.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;


    @Transactional
    public Optional<Course> saveCourse(CourseDTO courseDTO) {
        // received data can be checked in the method
        // check if the course with the given courseCode exists
        boolean isCourseCodeExists = courseRepository.selectExistsCourseCode(courseDTO.getCourseCode());

        if (isCourseCodeExists) {
            throw new CourseIsAlreadyExistException(ErrorMessageConstants.COURSE_EXISTS + courseDTO.getCourseCode());
        }

        Course course = courseMapper.mapFromCourseDTOtoWallet(courseDTO);

        return Optional.of(courseRepository.save(course));
    }
}
