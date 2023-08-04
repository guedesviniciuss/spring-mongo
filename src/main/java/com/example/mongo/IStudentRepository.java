package com.example.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends MongoRepository<Student, String> {

    Optional<Student> findByEmail(String email);
}
