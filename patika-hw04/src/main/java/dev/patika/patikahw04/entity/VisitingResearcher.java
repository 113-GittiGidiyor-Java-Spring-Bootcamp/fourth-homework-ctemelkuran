package dev.patika.patikahw04.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VisitingResearcher extends Instructor{
    // Visiting Researcher has hourly salary
    private double hourlySalary;

}
