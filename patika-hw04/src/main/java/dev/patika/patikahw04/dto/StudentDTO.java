package dev.patika.patikahw04.dto;

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

    @ApiModelProperty(example = "Ford Prefect")
    @NotBlank(message = "Course code is mandatory")
    private String name;

    @ApiModelProperty(example = "1997/06/27")
    @NotBlank(message = "Birth Date is mandatory")
    @DateTimeFormat
    private LocalDate birthDate;

    @ApiModelProperty(example = "Bostanli, Izmir")
    private String address;

    @ApiModelProperty(example = "Male or Female")
    private String gender;

}
