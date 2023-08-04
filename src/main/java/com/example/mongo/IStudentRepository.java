package com.example.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IStudentRepository extends MongoRepository<Student, String> {
}
