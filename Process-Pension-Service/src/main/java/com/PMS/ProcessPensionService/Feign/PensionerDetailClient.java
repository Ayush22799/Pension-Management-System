package com.PMS.ProcessPensionService.Feign;

import com.PMS.PensionerDetailService.Entity.PensionerDetail;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "Pensioner-Detail", url = "http://localhost:8181/PMS")
public interface PensionerDetailClient {
    @GetMapping("/Pensioner/fetch/{adhar}")
ResponseEntity<PensionerDetail> getPensionerDetail(@PathVariable("adhar") String adhar);
}
