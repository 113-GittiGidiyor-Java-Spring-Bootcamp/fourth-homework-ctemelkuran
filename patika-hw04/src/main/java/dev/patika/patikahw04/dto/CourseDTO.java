package dev.patika.patikahw04.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(example = "CS50")
    @NotBlank(message = "Course code is mandatory")
    private String courseCode;

    @ApiModelProperty(example = "Introduction to Computer Science")
    @NotBlank(message = "Course Name is mandatory")
    private String courseName;

    @ApiModelProperty(example = "8")
    @NotNull(message = "Credit Score is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int creditScore;
}
