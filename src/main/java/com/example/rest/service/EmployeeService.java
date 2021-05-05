package com.example.rest.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.rest.dto.EmployeeResponseDto;
import com.example.rest.entity.Employee;

public interface EmployeeService {
    
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(Long empId);
    
	public Employee createEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee, Long empId);
	
	public ResponseEntity<Employee> deleteEmployee(Long empId);
	
	public List<Employee> getEmployeeByFirstName(String empFirstName);
	
	public List<Employee> getEmployeeByLastName(String empLastName);
	
	public List<Employee> getEmployeeByFirstNameAndLastName(String empFirstName, String empLastName);
	
	public List<Employee> getEmployeeByFirstNameOrLastName(String empFirstName, String empLastName);
	
	List<Employee> getEmployeeByFirstNameUsingPageable(int pageNumber, int pageSize);
	
	public List<EmployeeResponseDto> getEmployeeFirstNameCount(String empFirstName);
	
	
	
	
}
