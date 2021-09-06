package dev.patika.patikahw04.repository;

import dev.patika.patikahw04.entity.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    /**
     * @param phoneNumber is unique for every instructor
     * @return boolean if instructor's phone number exists or not
     *
     * @author ctemelkuran
     */
    boolean existsInstructorByPhoneNumber(String phoneNumber);

}
