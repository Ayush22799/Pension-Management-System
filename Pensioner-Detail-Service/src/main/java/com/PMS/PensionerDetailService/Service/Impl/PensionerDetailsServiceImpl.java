package com.PMS.PensionerDetailService.Service.Impl;


import Response.*;
import com.PMS.PensionerDetailService.Entity.BankDetail;
import com.PMS.PensionerDetailService.Entity.PensionerDetail;
import com.PMS.PensionerDetailService.Service.PensionerDetailsService;
import com.PMS.PensionerDetailService.Utility.Utility;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

@Service
public class PensionerDetailsServiceImpl implements PensionerDetailsService {

    @Override
    public PensionerDetail getPensionerByAdhar(String adhar) {
        PensionerDetail pensionerDetail = new PensionerDetail();
        try (CSVReader csvReader = new CSVReader(new FileReader("Pensioner-Detail-Service/src/main/resources/details.csv"))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                if(values[0].equalsIgnoreCase(adhar)){
                    pensionerDetail = new PensionerDetail(values[1], Utility.parseDate(values[2]),values[3],Integer.parseInt(values[4]),Integer.parseInt(values[5]),values[6], new BankDetail(values[7],Long.parseLong(values[8]),values[9]));
                }
            }
        }
        catch (IOException | ParseException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return pensionerDetail;
    }
}
