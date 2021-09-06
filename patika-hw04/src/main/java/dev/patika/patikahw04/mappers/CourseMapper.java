package dev.patika.patikahw04.mappers;

import dev.patika.patikahw04.dto.CourseDTO;
import dev.patika.patikahw04.entity.Course;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface CourseMapper {

/*    @Autowired
    protected CourseService courseService;*/

    // @Mapping(target = "createdDate", expression = "java(java.time.LocalDate.now())")
    Course mapFromCourseDTOtoWallet(CourseDTO courseDTO);
    CourseDTO mapFromCourseToWalletDTO(Course course);

}
