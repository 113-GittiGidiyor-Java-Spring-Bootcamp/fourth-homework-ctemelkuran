package dev.patika.patikahw04.mappers;

import dev.patika.patikahw04.dto.CourseDTO;
import dev.patika.patikahw04.entity.Course;
import dev.patika.patikahw04.service.CourseService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CourseMapper {

    @Autowired
    protected CourseService courseService;

    @Mapping(target = "createDate", expression = "java(java.time.LocalDate.now())")
    public abstract Course mapFromCourseDTOtoWallet(CourseDTO courseDTO);
    public abstract CourseDTO mapFromCourseToWalletDTO(Course course);

}
