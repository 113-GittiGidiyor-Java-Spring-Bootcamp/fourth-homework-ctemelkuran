package dev.patika.patikahw04.mappers;

import dev.patika.patikahw04.dto.ExceptionLoggerDTO;
import dev.patika.patikahw04.entity.ExceptionLogger;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExceptionLoggerMapper {
    ExceptionLogger fromExceptionLoggerToDto(ExceptionLoggerDTO exceptionLoggerDTO);
}
