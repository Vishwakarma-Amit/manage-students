package com.student.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.student.api.entity.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {

}
