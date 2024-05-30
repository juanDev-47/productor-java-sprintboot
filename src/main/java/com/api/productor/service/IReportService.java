package com.api.productor.service;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

public interface IReportService {

    public String createBook(String name) throws IOException;


}
