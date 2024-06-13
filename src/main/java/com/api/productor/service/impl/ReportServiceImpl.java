package com.api.productor.service.impl;

import com.api.productor.service.IReportService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ReportServiceImpl implements IReportService {


    @Override
    public String createBook(String name) throws IOException {

//        1) create book
        Workbook book = new XSSFWorkbook();

        // 2) create sheets
        Sheet hoja = book.createSheet("informe 1");

        // create a bucle to iterate over the row, example 10 rows
//        for (int i = 0; i < 10; i++) {
//            Row fila = hoja.createRow(i);
//            for (int j = 0; j < 10; j++) {
//                Cell celda = fila.createCell(j);
//                celda.setCellValue("Fila " + i + " Columna " + j);
//            }
//        }
        // 3) create rows
        Row cabecera = hoja.createRow(2);
        // 4) create columns
        Cell nombre = cabecera.createCell(1);
        Cell edad = cabecera.createCell(2);
        Cell ciudad = cabecera.createCell(3);

        nombre.setCellValue("Nombre");
        edad.setCellValue("Edad");
        ciudad.setCellValue("Ciudad");

        Row fila1 = hoja.createRow(3);
        Cell nombre1 = fila1.createCell(1);
        Cell edad1 = fila1.createCell(2);
        Cell ciudad1 = fila1.createCell(3);

        nombre1.setCellValue("Juan");
        edad1.setCellValue(30);
        ciudad1.setCellValue("Medellin");

        Row fila2 = hoja.createRow(4);
        Cell nombre2 = fila2.createCell(1);
        Cell edad2 = fila2.createCell(2);
        Cell ciudad2 = fila2.createCell(3);

        nombre2.setCellValue("Linda K. Orellana D. A.");
        edad2.setCellValue(30);
        ciudad2.setCellValue("Medellin");



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


}
