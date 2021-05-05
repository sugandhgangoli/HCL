package com.example.rest.dto;

public class EmployeeResponseDto {

	private String empFirstName;
	private long count;

	public EmployeeResponseDto(String empFirstName, long count) {

		this.empFirstName = empFirstName;
		this.count = count;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public EmployeeResponseDto() {
		super();
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

}
