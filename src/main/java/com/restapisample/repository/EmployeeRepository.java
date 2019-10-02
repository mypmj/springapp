package com.restapisample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapisample.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
