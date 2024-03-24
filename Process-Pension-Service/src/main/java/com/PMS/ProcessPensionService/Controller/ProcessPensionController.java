package com.PMS.ProcessPensionService.Controller;

import com.PMS.ProcessPensionService.Entity.PensionDetail;
import com.PMS.ProcessPensionService.Entity.PensionerInput;
import com.PMS.ProcessPensionService.Service.ProcessPensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/PMS")
public class ProcessPensionController {
    @Autowired
    ProcessPensionService pensionService;

    @PostMapping("/PensionDetail")
    public ResponseEntity<PensionDetail> calculatePensionDetail(@RequestBody PensionerInput pensionerInput){
    return ResponseEntity.ok(pensionService.calculatePension(pensionerInput));
    }


}
