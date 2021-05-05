package com.example.rest.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.rest.dto.EmployeeResponseDto;
import com.example.rest.entity.Employee;
import com.example.rest.exception.ResourceNotFoundException;
import com.example.rest.repository.EmployeeRepository;
import com.example.rest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}

	// Get Employee By Id
	@Override
	public Employee getEmployeeById(Long empId) {
		return this.employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not Found" + empId));

	}

	// Get Employee By FirstName
	@Override
	public List<Employee> getEmployeeByFirstName(String empFirstName) {
		List<Employee> employee = employeeRepository.findByEmpFirstName(empFirstName);
		return employee;
	}

	// Get Employee By FirstNameUsingPageable
	@Override
	public List<Employee> getEmployeeByFirstNameUsingPageable(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Direction.ASC, "firstName"));
		List<Employee> employee = employeeRepository.findAll(pageable).getContent();
		return employee;
	}

	// create Employee
	@Override
	public Employee createEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	// Update Employee
	@Override
	public Employee updateEmployee(Employee employee, Long empId) {
		Employee existingEmployee = this.employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not Found" + empId));
		existingEmployee.setEmpFirstName(employee.getEmpFirstName());
		existingEmployee.setEmpLastName(employee.getEmpLastName());
		existingEmployee.setEmail(employee.getEmail());
		return this.employeeRepository.save(existingEmployee);
	}

	// Delete Employee
	@Override
	public ResponseEntity<Employee> deleteEmployee(Long empId) {
		Employee existingEmployee = this.employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not Found" + empId));
		this.employeeRepository.delete(existingEmployee);
		return ResponseEntity.ok().build();
	}

	// Get Employee By LastName
	@Override
	public List<Employee> getEmployeeByLastName(String empLastName) {
		List<Employee> employee = employeeRepository.findByEmpLastName(empLastName);
		return employee;
	}

	// Get Employee By FirstName And LastName
	@Override
	public List<Employee> getEmployeeByFirstNameAndLastName(String empFirstName, String empLastName) {
		List<Employee> employee = employeeRepository.findByEmpFirstNameAndEmpLastName(empFirstName, empLastName);
		return employee;
	}

	// Get Employee By FirstName Or LastName
	@Override
	public List<Employee> getEmployeeByFirstNameOrLastName(String empFirstName, String empLastName) {
		List<Employee> employee = employeeRepository.findByEmpFirstNameOrEmpLastName(empFirstName, empLastName);
		return employee;
	}

	// Get Employee FirstName Count
	@Override
	public List<EmployeeResponseDto> getEmployeeFirstNameCount(String empFirstName) {
		return employeeRepository.getEmployeeFirstNameCount(empFirstName);
	}

}
