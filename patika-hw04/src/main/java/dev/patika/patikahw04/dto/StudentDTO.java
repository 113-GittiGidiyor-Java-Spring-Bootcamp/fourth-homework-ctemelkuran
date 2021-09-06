package dev.patika.patikahw04.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(example = "Arthur Dent")
    @NotBlank(message = "Student Name is mandatory")
    private String name;

    @ApiModelProperty(example = "27-06-1997")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    @ApiModelProperty(example = "Bostanli, Izmir")
    private String address;

    @ApiModelProperty(example = "Male or Female")
    private String gender;

}
