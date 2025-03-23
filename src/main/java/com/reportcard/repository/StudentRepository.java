package com.reportcard.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.reportcard.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
}