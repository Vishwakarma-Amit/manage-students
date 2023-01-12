package com.student.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.student.api.entity.Subject;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {

} 
