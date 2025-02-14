package com.restapisample;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapisample.dao.EmployeeDao;
import com.restapisample.entities.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	EmployeeDao employeeDao;
	// Create new Employee  
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDao.save(emp);
	}
	// Get all employee details
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}
	// Get employee details
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empId ) {
		Employee emp;
		// check for Employee object existence
		try {
			emp = employeeDao.findById(empId);
		} catch(Exception e) {
			emp = null;
		}
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(emp);
	}
	// Update employee  
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empId, @Valid @RequestBody Employee empDetails) {
		Employee emp;
		// check for Employee object existence
		try {
			emp = employeeDao.findById(empId);
		} catch(Exception e) {
			emp = null;
		}
			
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		
		Employee updateEmp = employeeDao.save(emp); 
		
		return ResponseEntity.ok().body(updateEmp);
	}
	// Remove employee 
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable(value = "id") Long empId){
	
		Employee emp;
		// check for Employee object existence
		try {
			emp = employeeDao.findById(empId);
		} catch(Exception e) {
			emp = null;
		}
		
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		
		employeeDao.delete(emp);
		
		return ResponseEntity.ok().build();
	}
	
	
	
}
