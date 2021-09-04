package dev.patika.patikahw04.service;

import dev.patika.patikahw04.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

}
