package dev.patika.patikahw04.service;

import dev.patika.patikahw04.dto.InstructorDTO;
import dev.patika.patikahw04.entity.Instructor;
import dev.patika.patikahw04.exceptions.InstructorIsAlreadyExistException;
import dev.patika.patikahw04.mappers.InstructorMapper;
import dev.patika.patikahw04.repository.InstructorRepository;
import dev.patika.patikahw04.util.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;


    /**
     * @param instructorDTO takes Data Transfer Object as parameter
     * @return saved Instructor object returned
     */
    @Transactional
    public Optional<Instructor> saveInstructor(InstructorDTO instructorDTO) {
        // check the phone number
        boolean isInstructorExists = instructorRepository.existsInstructorByPhoneNumber(instructorDTO.getPhoneNumber());

        if (isInstructorExists) {
            throw new InstructorIsAlreadyExistException(ErrorMessageConstants.INSTRUCTOR_EXISTS + instructorDTO.getPhoneNumber());
        }
        Instructor instructor = instructorMapper.mapFromInstructorDTOtoInstructor(instructorDTO);

        return Optional.of(instructorRepository.save(instructor));
    }

    /** Method to show all entities
     *
     * @return all entities found as a List.
     */
    public List<Instructor> findAll() {
        List<Instructor> instructorList = new ArrayList<>();
        Iterable<Instructor> instructorIterable = instructorRepository.findAll();
        instructorIterable.iterator().forEachRemaining(instructorList::add);
        return instructorList;

    }

    /** Used to update
     * Mapper is called to convert DTO to entity object
     *
     * @param instructorDTO
     * @return Optional Instructor
     */
    @Transactional
    public Optional<Instructor> updateInstructor(InstructorDTO instructorDTO, long instructorId) {
        instructorRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));


        Instructor instructor = instructorMapper.mapFromInstructorDTOtoInstructor(instructorDTO);
        return Optional.of(instructorRepository.save(instructor));
    }

    /** Find required entity by Id
     *
     * @param instructorId
     * @return found entity
     */
    public Instructor findInstructorById(long instructorId) {
        Instructor foundInstructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
        return foundInstructor;
    }


    /**
     * Deletes the object with given id
     *
     * @param instructorId
     * @return
     */
    @Transactional
    public String deleteById(long instructorId) {

        Instructor foundInstructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        instructorRepository.delete(foundInstructor);
        return "Instructor deleted with id: " + instructorId;
    }
}