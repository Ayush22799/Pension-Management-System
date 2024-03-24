package com.PMS.ProcessPensionService.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PensionDetail {
    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date DOB;
    private String PAN;
    private String pensionType;
    private double pensionAmount;

    public PensionDetail(String name, Date DOB, String PAN, String pensionType){
        this.name = name;
        this.DOB = DOB;
        this.PAN = PAN;
        this.pensionType = pensionType;
    }
}
