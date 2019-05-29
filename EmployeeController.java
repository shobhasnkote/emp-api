package com.example.empapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empapi.model.Employee;
import com.example.empapi.service.EmployeeRepository;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	
	List<Employee> empList = new ArrayList<>();

	@GetMapping("/")
	public List<Employee> getAllEmp(){
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Employee getEmpById(@PathVariable String id) {
		return repository.findById(id).get();
	}
	@PutMapping("/")
	public Employee updateEmpById(@RequestBody Employee employee) {
		Employee emp = repository.findById(employee.getId()).get();
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setSalary(employee.getSalary());
		repository.save(emp);
		return emp;
	}

	@PostMapping("/")
	public Employee creaeteEmp(@RequestBody Employee employes) {
		//		empList.add(employes);
		List<Employee> empList = new ArrayList<>();
		empList.add(employes);
		repository.saveAll(empList);
		return employes;
	}
}
