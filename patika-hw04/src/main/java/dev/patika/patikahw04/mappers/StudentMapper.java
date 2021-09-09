package dev.patika.patikahw04.mappers;

import dev.patika.patikahw04.dto.StudentDTO;
import dev.patika.patikahw04.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student mapFromStudentDTOtoStudent(StudentDTO studentDTO);
    StudentDTO mapFromStudentToStudentDTO(Student student);
}
