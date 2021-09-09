package dev.patika.patikahw04.mappers;

import dev.patika.patikahw04.dto.InstructorDTO;
import dev.patika.patikahw04.entity.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface InstructorMapper {

    Instructor mapFromInstructorDTOtoInstructor(InstructorDTO instructorDTO);
    InstructorDTO mapFromInstructorToInstructorDTO(Instructor instructor);

}
