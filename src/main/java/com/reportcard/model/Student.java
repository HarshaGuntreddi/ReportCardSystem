package com.reportcard.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "students")
@Data
public class Student {
    @Id
    private String id;
    private String name;
    private Map<String, Map<String, Double>> subjectScores; // e.g., {"Term1": {"Physics": 78.0, "Chemistry": 72.0}}
    private Map<String, Double> finalScores; // e.g., {"Science": 84.98, "English": 85.8}
}