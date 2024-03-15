package com.PMS.PensionerDetailService.Service;

import Response.Response;
import com.PMS.PensionerDetailService.Entity.PensionerDetail;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.List;

public interface PensionerDetailsService {
   PensionerDetail getPensionerByAdhar(String Adhar);
}
