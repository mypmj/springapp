/**
 * 
 */
package com.restapisample.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Jinesh Madhavan
 *
 */
@Entity
@Table(name = "employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	
	@NotBlank 
	private String name;
	
	@NotBlank
	private String designation;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
