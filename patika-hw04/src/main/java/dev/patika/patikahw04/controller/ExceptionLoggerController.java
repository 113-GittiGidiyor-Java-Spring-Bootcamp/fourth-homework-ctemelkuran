package dev.patika.patikahw04.controller;

import dev.patika.patikahw04.service.ExceptionLoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exception-logs")
public class ExceptionLoggerController {


    private final ExceptionLoggerService exceptionLoggerService;

    @Autowired
    public ExceptionLoggerController(ExceptionLoggerService exceptionLoggerService) {
        this.exceptionLoggerService = exceptionLoggerService;
    }
}
