package com.PMS.PensionerDetailService.Entity;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PensionerDetail {

    private String name;
    private Date DOB;
    private String PAN;
    private int salary;
    private int Allowances;
    private String pensionType;
    private BankDetail Bank;
}
