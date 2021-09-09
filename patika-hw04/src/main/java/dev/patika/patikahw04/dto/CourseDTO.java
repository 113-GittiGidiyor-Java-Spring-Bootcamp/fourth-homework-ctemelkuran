package dev.patika.patikahw04.dto;

import dev.patika.patikahw04.entity.Instructor;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(example = "CS50")
    @NotBlank(message = "Course Code is mandatory")
    private String courseCode;

    @ApiModelProperty(example = "Introduction to Computer Science")
    @NotBlank(message = "Course Name is mandatory")
    private String courseName;

    @ApiModelProperty(example = "8")
    @NotNull(message = "Credit Score is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int creditScore;

    @ApiModelProperty(example = "1")
    @NotNull(message = "An instructor is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Instructor instructorId;

    @ApiModelProperty(example = "[1, 2, 3, 4]")
    private List<Long> enrolledStudentIds;
}
