package com.PMS.PensionerDetailService.Entity;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankDetail {
    private String BankName;
    private long accountNumber;
    private String bankType;
}
