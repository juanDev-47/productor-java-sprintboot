package com.api.productor.controllers;

import com.api.productor.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private IReportService reportService;

    @GetMapping("/create/{name}")
    public ResponseEntity<?> createReport(@PathVariable String name) throws IOException {
        return ResponseEntity.ok(reportService.createBook(name));
    }
}
