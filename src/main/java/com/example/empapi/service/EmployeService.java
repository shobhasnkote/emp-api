package com.example.empapi.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.empapi.controller.Employes;

@Repository
public interface EmployeService extends MongoRepository<Employes,String>{
	

}
