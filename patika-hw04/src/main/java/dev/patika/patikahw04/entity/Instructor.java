package dev.patika.patikahw04.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = PermanentInstructor.class, name = "PermanentInstructor"),
        @JsonSubTypes.Type(value = VisitingResearcher.class, name = "VisitingResearcher")}) // Instructor type should be declared
public class Instructor extends AbstractBaseEntity {

    private String name;
    private String address;
    private String phoneNumber;

    // One instructor may have several courses
    // mapping is handled at One to Many relation
    // @JsonManagedReference
    @OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY)
    List<Course> instructorCourses = new ArrayList<>();


}
