package dev.patika.patikahw04.service;

import dev.patika.patikahw04.dto.ExceptionLoggerDTO;
import dev.patika.patikahw04.entity.ExceptionLogger;
import dev.patika.patikahw04.mappers.ExceptionLoggerMapper;
import dev.patika.patikahw04.repository.ExceptionLoggerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExceptionLoggerService {
    private final ExceptionLoggerRepository exceptionLoggerRepository;
    private final ExceptionLoggerMapper exceptionLoggerMapper;

    public Optional<ExceptionLogger> createLog(ExceptionLogger exceptionLogger){
        return Optional.of(exceptionLoggerRepository.save(exceptionLogger));
    }
/*
    public List<ExceptionLoggerDTO> findAllLogsOrderedByDate(){
        return exceptionLoggerRepository.findAllBy
    }*/
}
