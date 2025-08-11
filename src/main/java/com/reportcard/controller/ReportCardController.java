package com.reportcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reportcard.model.Student;
import com.reportcard.service.ReportCardService;

@RestController
@RequestMapping("/api/reportcard")
public class ReportCardController {

    @Autowired
    private ReportCardService reportCardService;

    @PostMapping("/generate")
    public Student generateReportCard(@RequestBody Student student) {
        return reportCardService.calculateReportCard(student);
    }
}
