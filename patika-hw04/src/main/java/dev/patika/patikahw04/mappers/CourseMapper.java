package dev.patika.patikahw04.mappers;

import dev.patika.patikahw04.dto.CourseDTO;
import dev.patika.patikahw04.entity.Course;
import dev.patika.patikahw04.service.CourseService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

// MapStruct has the best average working time
@Mapper (componentModel = "spring")
public abstract class CourseMapper {

    @Autowired
    protected CourseService courseService;

    /**
     *
     * @param courseDTO gets converted to
     * @return Course entity
     */
    // target is the students attribute in Course entity
    // @Mapping(target = "students", expression = "java(courseService.findStudentsByCourseId(courseDTO.getId()))")
    public abstract Course mapFromCourseDTOtoCourse(CourseDTO courseDTO);
    public abstract CourseDTO mapFromCourseToCourseDTO(Course course);

}
