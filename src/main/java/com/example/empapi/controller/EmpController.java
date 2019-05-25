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

import com.example.empapi.service.EmployeService;

@CrossOrigin
@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmployeService repository;
	
	List<Employes> empList = new ArrayList<>();
	
	@GetMapping("/")
	public List<Employes> getAllEmp(){
		return repository.findAll();
		
//		return getEmpList();
	}
	
	private List<Employes> getEmpList() {
		List<Employes> empList = new ArrayList<>();
		Employes emp1 = new Employes();
		emp1.setId("1");
		emp1.setFirstName("mona1");
		emp1.setFirstName("lisa1");
		emp1.setSalary(1234);
		
		Employes emp2 = new Employes();
		emp2.setId("2");
		emp2.setFirstName("mona1");
		emp2.setFirstName("lisa1");
		emp2.setSalary(1234);
		
		
		Employes emp3 = new Employes();
		emp3.setId("1");
		emp3.setFirstName("mona1");
		emp3.setFirstName("lisa1");
		emp3.setSalary(1234);
		
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		return empList;
	}
	
	@GetMapping("/{id}")
	public Employes getEmpById(@PathVariable String id) {
		return repository.findById(id).get();

//		return empList.stream().filter(emp -> emp.getId().equals(id)).findFirst().get();
	}
	
	@PutMapping("/{id}")
	public Employes updateEmpById(@PathVariable String id, @RequestBody Employes employes) {
//		Employes empl = empList.stream().filter(emp -> emp.getId().equals(id)).findFirst().get();
//		empl.setFirstName(employes.getFirstName());
//		empl.setLastName(employes.getLastName());
//		empl.setSalary(employes.getSalary());
//		
////		empList.add(employes);
		
		Employes emp = repository.findById(id).get();
		emp.setFirstName(employes.getFirstName());
		emp.setLastName(employes.getLastName());
		emp.setSalary(employes.getSalary());
		repository.save(emp);
		return emp;
	}
	
	@PostMapping("/")
	public Employes creaeteEmp(@RequestBody Employes employes) {
//		empList.add(employes);
		List<Employes> empList = new ArrayList<>();
		empList.add(employes);
		repository.saveAll(empList);
		return employes;
	}
}
