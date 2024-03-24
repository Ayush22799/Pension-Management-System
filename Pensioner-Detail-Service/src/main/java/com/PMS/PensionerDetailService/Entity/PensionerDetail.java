package com.PMS.PensionerDetailService.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PensionerDetail implements Serializable {

    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date DOB;
    private String PAN;
    private int salary;
    private int Allowances;
    private String pensionType;
    private BankDetail Bank;
}
