package com.api.productor.service.impl;

import com.api.productor.controllers.dto.MakerDTO;
import com.api.productor.service.IMakerService;
import com.api.productor.service.IReportService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private IMakerService makerService;


    @Override
    public String createBook(String name) throws IOException {

        // get all the makers
        List<MakerDTO> makers = getMakers();

//        1) create book
        XSSFWorkbook book = new XSSFWorkbook();

        // 2) create sheets
        XSSFSheet hoja = book.createSheet("informe 1");

        // create the header
        XSSFRow cabecera = hoja.createRow(0);
        XSSFCell celda1 = cabecera.createCell(1);
        XSSFCell celda2 = cabecera.createCell(2);
        XSSFCell celda3 = cabecera.createCell(3);

        // create cell styles
        XSSFCellStyle style = book.createCellStyle();

        // config styles
        style.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);

        // config cel
        celda1.setCellValue("Full Name");
        celda1.setCellStyle(style);
        celda2.setCellValue("Country");
        celda2.setCellStyle(style);
        celda3.setCellValue("Description");
        celda3.setCellStyle(style);

        hoja.autoSizeColumn(1);
        hoja.autoSizeColumn(2);
        hoja.autoSizeColumn(3);

        // create a bucle to iterate over the makers list
        for (int i = 1; i < makers.size(); i++) {
            XSSFRow fila = hoja.createRow(i);
            XSSFCell cel1 = fila.createCell(1);
            cel1.setCellStyle(style);
            XSSFCell cel2 = fila.createCell(2);
            cel2.setCellStyle(style);
            XSSFCell cel3 = fila.createCell(3);
            cel3.setCellStyle(style);

            cel1.setCellValue(makers.get(i).getFullName());
            cel2.setCellValue(makers.get(i).getCountry());
            cel3.setCellValue(makers.get(i).getDescription());
        }


        try {
            OutputStream fileOut = new FileOutputStream("src/main/resources/" + name + ".xlsx");

            book.write(fileOut);

            book.close();
            fileOut.close();
            return "Report created";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error creating report";
    }

    public void deleteBook(String name) throws IOException {
        // how to delete a file, exampe: workbook.xlsx
        // name = "src/main/resources/workbook.xlsx"
        try {
            Path path = Path.of(name);
            if(Files.exists(path) ){
                Files.delete(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<MakerDTO> getMakers() {
        return makerService.findAll().stream().map(maker -> MakerDTO.builder()
                .id(maker.getId())
                .fullName(maker.getFullName())
                .country(maker.getCountry())
                .description(maker.getDescription())
                .products(maker.getProducts())
                .build()).toList();
    }


}
