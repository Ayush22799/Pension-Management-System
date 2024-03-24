package com.PMS.ProcessPensionService.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Pattern;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PensionerInput {

    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date DOB;
    private String PAN;
    @Pattern(regexp = "[0-9]{12}", message = "Aadhaar Number is in invalid format")
    private String Aadhar;
    private String pensionType;
}
