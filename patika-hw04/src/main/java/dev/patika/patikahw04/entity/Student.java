package dev.patika.patikahw04.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends AbstractBaseEntity{
    // instance variables

    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    private String address;
    private String gender;

    // With regard to normalisation Hibernate creates an association table (E.g student_courses)
    // A student can attend to 0 or more
    // @ManyToMany relationships can use FetchType.LAZY
    //@JsonIgnoreProperties({"students", "instructor"})
    // @JsonManagedReference
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Course> studentCourses = new ArrayList<>();

}
