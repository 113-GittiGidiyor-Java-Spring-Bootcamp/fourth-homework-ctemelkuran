package dev.patika.patikahw04.mappers;

import dev.patika.patikahw04.dto.CourseDTO;
import dev.patika.patikahw04.entity.Course;
import org.mapstruct.Mapper;

// MapStruct has the best average working time
@Mapper (componentModel = "spring")
public interface CourseMapper {

/*    @Autowired
    protected CourseService courseService;*/

    // @Mapping(target = "createdDate", expression = "java(java.time.LocalDate.now())")
    Course mapFromCourseDTOtoCourse(CourseDTO courseDTO);
    CourseDTO mapFromCourseToCourseDTO(Course course);

}
