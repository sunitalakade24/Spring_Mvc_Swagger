package com.example.demo.Controller;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Employee;
import com.example.demo.Service.EmployeeServiceI;

@RestController
@RequestMapping("EmployeeAll")
public class EmployeeController {
   Logger logger=LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeServiceI employeeServiceI;

	@PostMapping
	public ResponseEntity<String> saveEMployee(@RequestBody Employee emp) {
		boolean saveEmployee = employeeServiceI.saveEmployee(emp);
		if (saveEmployee) {
			return new ResponseEntity<String>("Employee save Successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Employee not saved Successfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<String> UpdateEMployee(@RequestBody Employee emp) {
		
		
		boolean saveEmployee = employeeServiceI.saveEmployee(emp);
		
		if (saveEmployee) {
			return new ResponseEntity<String>("Employee Update Successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Employee not Update Successfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("saveAllEmployee")
	public ResponseEntity<String> saveAllEmployee(@RequestBody List<Employee> emp) {
		boolean saveAllEmployee = employeeServiceI.saveAllEmployee(emp);
		if (saveAllEmployee) {
			return new ResponseEntity<String>("All Employee save Successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Not saved all Employee successfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("findStudentById/{id}")
	public ResponseEntity<Employee> findStudentById(@PathVariable int id) {
		Employee findByidEmployee = employeeServiceI.findByidEmployee(id);
		return new ResponseEntity<Employee>(findByidEmployee, HttpStatus.OK);
	}

	@GetMapping("findAllStudentById")
	public ResponseEntity<List<Employee>> findAllStudentById(@PathVariable List<Integer> id1) {
		List<Employee> findByAllEmployee = employeeServiceI.findByAllEmployee(id1);
		return new ResponseEntity<List<Employee>>(findByAllEmployee, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> findAllEmployee()

	{
		List<Employee> findAllEmployee = employeeServiceI.findAllEmployee();
		return new ResponseEntity<List<Employee>>(findAllEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {
		String deleteEmployeeById = employeeServiceI.deleteEmployeeById(id);
		return new ResponseEntity<String>(deleteEmployeeById, HttpStatus.OK);

	}
	@DeleteMapping
   public ResponseEntity<String> deleteAllRecord()
   {
	   String deleteEmployeeAll = employeeServiceI.deleteEmployeeAll();
	   return new ResponseEntity<String>(deleteEmployeeAll,HttpStatus.OK);
	   
   }
}
