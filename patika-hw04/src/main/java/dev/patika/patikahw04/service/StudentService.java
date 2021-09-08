package dev.patika.patikahw04.service;

import dev.patika.patikahw04.dto.StudentDTO;
import dev.patika.patikahw04.entity.Student;
import dev.patika.patikahw04.exceptions.StudentAgeNotValidException;
import dev.patika.patikahw04.mappers.StudentMapper;
import dev.patika.patikahw04.repository.StudentRepository;
import dev.patika.patikahw04.util.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;



    /**
     * @param studentDTO takes Data Transfer Object as parameter
     * @return saved Student object returned
     */
    @Transactional
    public Optional<Student> saveStudent(StudentDTO studentDTO) {
        // received data can be checked in the method
        Student student = studentMapper.mapFromStudentDTOtoWallet(studentDTO);

        int studentAge = LocalDate.now().getYear() - student.getBirthDate().getYear();

        if (studentAge < 18 || studentAge > 40) {
            throw new StudentAgeNotValidException(ErrorMessageConstants.AGE_IS_NOT_VALID);
        }

        return Optional.of(studentRepository.save(student));
    }
}