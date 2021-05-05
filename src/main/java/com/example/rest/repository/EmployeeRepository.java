package com.example.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.rest.dto.EmployeeResponseDto;
import com.example.rest.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByEmpFirstName(String empFirstName);

	List<Employee> findByEmpLastName(String empLastName);

	List<Employee> findByEmpFirstNameAndEmpLastName(String empFirstName, String empLastName);

	List<Employee> findByEmpFirstNameOrEmpLastName(String empFirstName, String empLastName);

	@Query("select new com.example.rest.dto.EmployeeResponseDto(empFirstName, count(*)) from Employee where empFirstName=:empFirstName group by empFirstName")
	List<EmployeeResponseDto> getEmployeeFirstNameCount(String empFirstName);

}
