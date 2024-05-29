package com.api.productor.controllers;

import com.api.productor.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private IReportService reportService;

    @GetMapping("/create")
    public ResponseEntity<?> createReport() {
        return ResponseEntity.ok(reportService.createBook());
    }
}
