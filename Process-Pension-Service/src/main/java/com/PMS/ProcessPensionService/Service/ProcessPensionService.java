package com.PMS.ProcessPensionService.Service;


import com.PMS.PensionerDetailService.Entity.PensionerDetail;
import com.PMS.ProcessPensionService.Entity.PensionDetail;
import com.PMS.ProcessPensionService.Entity.PensionerInput;

public interface ProcessPensionService {
PensionDetail calculatePension(PensionerInput input);
}
