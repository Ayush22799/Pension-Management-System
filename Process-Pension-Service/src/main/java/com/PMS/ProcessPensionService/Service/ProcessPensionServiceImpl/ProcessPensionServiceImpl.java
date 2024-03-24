package com.PMS.ProcessPensionService.Service.ProcessPensionServiceImpl;

import com.PMS.PensionerDetailService.Entity.PensionerDetail;
import com.PMS.ProcessPensionService.Entity.PensionDetail;
import com.PMS.ProcessPensionService.Entity.PensionerInput;
import com.PMS.ProcessPensionService.Feign.PensionerDetailClient;
import com.PMS.ProcessPensionService.Service.ProcessPensionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProcessPensionServiceImpl implements ProcessPensionService {

    @Autowired
    PensionerDetailClient pensionerDetailClient;

    // Method to get pension detail by Adhar
    public PensionerDetail getPensionerDetail(String Adhar){
        ResponseEntity<PensionerDetail> pensionerDetail = pensionerDetailClient.getPensionerDetail(Adhar);
        if(pensionerDetail.getStatusCode().is4xxClientError()){
           log.error("Pensioner Details could not be retrieved from client");
        }
        return pensionerDetail.getBody();
    }

    @Override
    public PensionDetail calculatePension(PensionerInput input) {
    PensionerDetail pensionerDetail = getPensionerDetail(input.getAadhar());
    PensionDetail pensionDetail = new PensionDetail(
            pensionerDetail.getName(),
            pensionerDetail.getDOB(),
            pensionerDetail.getPAN(),
            pensionerDetail.getPensionType()
    );

    if(pensionerDetail.getPensionType().equalsIgnoreCase("Self")){
    log.info("Pensioner is identified as self pension type");
    pensionDetail.setPensionAmount((0.8 * pensionerDetail.getSalary()) + pensionerDetail.getAllowances());
    }
        if(pensionerDetail.getPensionType().equalsIgnoreCase("Family")){
            log.info("Pensioner is identified as Family pension type");
            pensionDetail.setPensionAmount((0.5 * pensionerDetail.getSalary()) + pensionerDetail.getAllowances());
        }
    return pensionDetail;
    }
}
