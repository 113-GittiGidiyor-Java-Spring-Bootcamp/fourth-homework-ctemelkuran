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
public class InstructorDTO {
    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(example = "Ford Prefect")
    @NotBlank(message = "Instructor name is mandatory")
    private String name;

    @ApiModelProperty(example = "Bostanli, Izmir")
    private String address;

    @ApiModelProperty(example = "05381234556")
    @NotNull(message = "Phone Number is is mandatory")
    private String phoneNumber;


}
