package com.reportcard.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reportcard.model.Student;
import com.reportcard.repository.StudentRepository;

@Service
public class ReportCardService {

    @Autowired
    private StudentRepository studentRepository;

    public Student calculateReportCard(Student student) {
        Map<String, Map<String, Double>> subjectScores = student.getSubjectScores();
        Map<String, Double> finalScores = new HashMap<>();

        // Calculate Term Scores
        for (String term : subjectScores.keySet()) {
            Map<String, Double> termScores = subjectScores.get(term);

            // Science weighted calculation (Physics 40%, Chemistry 30%, Biology 30%)
            double scienceScore = calculateScienceScore(termScores);
            termScores.put("Science", scienceScore);

            // English weighted calculation (direct pass-through from example)
            double englishScore = calculateTermScore(termScores.get("English"));
            termScores.put("English", englishScore);
        }

        // Aggregate final scores across terms (assuming equal term weightage for simplicity)
        finalScores.put("Science", calculateFinalScore(subjectScores, "Science"));
        finalScores.put("English", calculateFinalScore(subjectScores, "English"));

        student.setFinalScores(finalScores);
        return studentRepository.save(student);
    }

    private double calculateScienceScore(Map<String, Double> termScores) {
        double physics = termScores.getOrDefault("Physics", 0.0);
        double chemistry = termScores.getOrDefault("Chemistry", 0.0);
        double biology = termScores.getOrDefault("Biology", 0.0);
        return (0.4 * physics) + (0.3 * chemistry) + (0.3 * biology);
    }

    private double calculateTermScore(Double examScore) {
        // Example weights: Exam1 (10%), Exam2 (10%), Exam3 (80%)
        return examScore;
    }

    private double calculateFinalScore(Map<String, Map<String, Double>> subjectScores, String subject) {
        double total = 0.0;
        int termCount = subjectScores.size();
        for (Map<String, Double> termScores : subjectScores.values()) {
            total += termScores.getOrDefault(subject, 0.0);
        }
        return total / termCount; // Equal weightage across terms
    }
}
