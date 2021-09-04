package dev.patika.patikahw04.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course extends AbstractBaseEntity{


    private String courseCode;
    private String courseName;
    private int creditScore;
    // courseCode unique olsa da best practice olarak id tanımlanır
    // autogenerate sağlanmaz, string olduğu için syntax kontrolü zor olur

    @JsonIgnore
    @ManyToMany(mappedBy = "studentCourses", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    //@JsonIgnoreProperties("{instructorCourses}")
    // @JsonBackReference
    @ManyToOne
    private Instructor instructor;



}
