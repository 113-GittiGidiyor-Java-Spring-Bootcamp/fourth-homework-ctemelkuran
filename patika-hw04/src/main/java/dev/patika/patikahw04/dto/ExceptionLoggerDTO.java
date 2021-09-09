package dev.patika.patikahw04.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExceptionLoggerDTO {
    private Long id;
    private String exceptionType;
    private LocalDate exceptionThrownDate;
    private String exceptionMessage;
}
