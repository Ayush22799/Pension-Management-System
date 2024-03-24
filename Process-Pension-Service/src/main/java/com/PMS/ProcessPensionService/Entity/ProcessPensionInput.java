package com.PMS.ProcessPensionService.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProcessPensionInput {
    private String pensionType;
    private double pensionAmount;
}
