package dev.patika.patikahw04.service;

import dev.patika.patikahw04.dto.StudentDTO;
import dev.patika.patikahw04.dto.StudentDTO;
import dev.patika.patikahw04.entity.Student;
import dev.patika.patikahw04.entity.Student;
import dev.patika.patikahw04.exceptions.StudentAgeNotValidException;
import dev.patika.patikahw04.mappers.StudentMapper;
import dev.patika.patikahw04.repository.StudentRepository;
import dev.patika.patikahw04.util.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        Student student = studentMapper.mapFromStudentDTOtoStudent(studentDTO);

        int studentAge = LocalDate.now().getYear() - student.getBirthDate().getYear();

        if (studentAge < 18 || studentAge > 40) {
            throw new StudentAgeNotValidException(ErrorMessageConstants.AGE_IS_NOT_VALID);
        }

        return Optional.of(studentRepository.save(student));
    }

    /** Method to show all entities
     *
     * @return all entities found as a List.
     */
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Iterable<Student> studentIterable = studentRepository.findAll();
        studentIterable.iterator().forEachRemaining(studentList::add);
        return studentList;

    }

    /** Used to update
     * Mapper is called to convert DTO to entity object
     *
     * @param studentDTO
     * @return Optional Student
     */
    @Transactional
    public Optional<Student> updateStudent(StudentDTO studentDTO, long studentId) {
        studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));


        Student student = studentMapper.mapFromStudentDTOtoStudent(studentDTO);
        return Optional.of(studentRepository.save(student));
    }

    /** Find required entity by Id
     *
     * @param studentId
     * @return found entity
     */
    public Student findStudentById(long studentId) {
        Student foundStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return foundStudent;
    }


    /**
     * Deletes the object with given id
     *
     * @param studentId
     * @return
     */
    @Transactional
    public String deleteById(long studentId) {

        Student foundStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        studentRepository.delete(foundStudent);
        return "Student deleted with id: " + studentId;
    }
}