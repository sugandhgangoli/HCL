package com.example.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.dto.EmployeeResponseDto;
import com.example.rest.entity.Employee;
import com.example.rest.exception.ResourceNotFoundException;
import com.example.rest.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Get All Employees
	@GetMapping
	public List<Employee> getAllEmployees() {
		return this.employeeService.getAllEmployees();
	}

	// Get Employee By Id
	// both id should match
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") long empId) {
		return this.employeeService.getEmployeeById(empId);
	}

	// Get Employee By FirstName
	@GetMapping("/nameSearch")
	public List<Employee> getEmployeeByFirstName(@RequestParam String empFirstName) {
		return this.employeeService.getEmployeeByFirstName(empFirstName);
	}

	// Get Number Of Employee Count
	@GetMapping("/nameSearchCount")
	public List<EmployeeResponseDto> getEmployeeFirstNameCount(@RequestParam String empFirstName) {
		return this.employeeService.getEmployeeFirstNameCount(empFirstName);
	}

	// Get Employee By FirstName Using Pageable
	@GetMapping("/nameSearchPageable")
	public List<Employee> getEmployeeByFirstNameUsingPageable(@RequestParam int pageNumber,
			@RequestParam int pageSize) {
		return this.employeeService.getEmployeeByFirstNameUsingPageable(pageNumber, pageSize);
	}

	// Get Employee By LastName
	@GetMapping("/nameSearchByLastName")
	public List<Employee> getEmployeeByLastName(@RequestParam String empLastName) {
		return this.employeeService.getEmployeeByLastName(empLastName);
	}

	// Get Employee By FirstNameAndLastName
	@GetMapping("/nameSearchByFirstNameAndLastName")
	public List<Employee> getEmployeeByFirstNameAndLastName(@RequestParam String empFirstName,
			@RequestParam String empLastName) {
		return this.employeeService.getEmployeeByFirstNameAndLastName(empFirstName, empLastName);
	}

	// Get Employee By FirstNameOrLastName
	@GetMapping("/nameSearchByFirstNameOrLastName")
	public List<Employee> getEmployeeByFirstNameOrLastName(@RequestParam String empFirstName,
			@RequestParam String empLastName) {
		return this.employeeService.getEmployeeByFirstNameOrLastName(empFirstName, empLastName);
	}

	// Create a Employee
	// JSON will directly map to the Employee object
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeService.createEmployee(employee);
	}

	// Update the Employee by Id
	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable(value = "id") long empId) {
		return this.employeeService.updateEmployee(employee, empId);
	}

	// Delete the Employee by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") long empId) {
		return this.employeeService.deleteEmployee(empId);

	}
}
