package com.example.empapi.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.empapi.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee,String>{
	

}
