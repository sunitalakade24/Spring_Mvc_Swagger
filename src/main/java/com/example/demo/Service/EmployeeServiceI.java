package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Employee;

public interface EmployeeServiceI {
	
	public boolean saveEmployee(Employee emp);
	public boolean updateEmployee(Employee emp);

	public boolean saveAllEmployee(List<Employee> emp);
	public Employee findByidEmployee(int id);
	public List<Employee> findByAllEmployee(List<Integer>emp);
	public List<Employee> findAllEmployee();
	public String deleteEmployeeById(int id);
	public String deleteEmployeeAll();
	
	

}
