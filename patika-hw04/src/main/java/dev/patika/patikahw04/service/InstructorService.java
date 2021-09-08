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
        Instructor instructor = instructorMapper.mapFromInstructorDTOtoWallet(instructorDTO);

        return Optional.of(instructorRepository.save(instructor));
    }
}