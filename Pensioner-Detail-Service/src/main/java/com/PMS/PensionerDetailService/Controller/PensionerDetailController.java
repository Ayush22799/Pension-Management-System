package com.PMS.PensionerDetailService.Controller;

import Response.Response;
import com.PMS.PensionerDetailService.Entity.PensionerDetail;
import com.PMS.PensionerDetailService.Service.PensionerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/PMS")
public class PensionerDetailController {

    @Autowired
    PensionerDetailsService pensionerDetailsService;

    @GetMapping("/Pensioner/fetch/{adhar}")
    public ResponseEntity<PensionerDetail> getPensionerByAdhar(@PathVariable("adhar") String adhar)  {
        return ResponseEntity.ok(pensionerDetailsService.getPensionerByAdhar(adhar));
    }
}
