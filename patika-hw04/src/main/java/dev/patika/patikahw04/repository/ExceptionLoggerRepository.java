package dev.patika.patikahw04.repository;

import dev.patika.patikahw04.entity.ExceptionLogger;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExceptionLoggerRepository extends CrudRepository<ExceptionLogger, Long> {
    List<ExceptionLogger> findExceptionLoggersByExceptionType(String exceptionType);
    List<ExceptionLogger> findAllByExceptionThrownDate(LocalDate exceptionDate);
}
