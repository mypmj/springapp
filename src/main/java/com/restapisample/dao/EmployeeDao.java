package com.restapisample.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapisample.entities.Employee;
import com.restapisample.repository.EmployeeRepository;

@Service
public class EmployeeDao {
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	// create employee
	public Employee save(Employee emp) {
		return employeeRepo.save(emp);
	}
	// get employee details
	public Employee findById(Long empId) {
		return employeeRepo.getOne(empId);
	}
	// get all employee info
	public List<Employee> findAll(){
		return employeeRepo.findAll();
	}
	// remove employee
	public void delete(Employee emp) {
		employeeRepo.delete(emp);
	}

}
