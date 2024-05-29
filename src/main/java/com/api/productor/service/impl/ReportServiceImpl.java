package com.api.productor.service.impl;

import com.api.productor.service.IReportService;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.OutputStream;

@Service
public class ReportServiceImpl implements IReportService {


    @Override
    public Workbook createBook() {
        Workbook book = new XSSFWorkbook();

        try {
            OutputStream fileOut = new FileOutputStream("src/main/resources/workbook.xlsx");
            book.createSheet("Sheet 1");
            book.createSheet("Sheet 2");
            book.createSheet("Sheet 3");
            book.write(fileOut);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }


}
