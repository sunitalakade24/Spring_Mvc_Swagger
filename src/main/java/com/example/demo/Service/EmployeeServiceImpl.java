package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {
    @Autowired
	private EmployeeRepository emplyeeRepository;
	@Override
	public boolean saveEmployee(Employee emp) {
		Employee save = emplyeeRepository.save(emp);
		if(save!=null)
		{
			return true;
			
		}
		else
		{
		return false;
		}
	}
	@Override
	public boolean saveAllEmployee(List<Employee> emp) {
		List<Employee> saveAll = emplyeeRepository.saveAll(emp);
		if(saveAll!=null)
		{
			return true;
		}
		else
		{
		return false;
		}
	}
	@Override
	public Employee findByidEmployee(int id) {
		Optional<Employee> findById = emplyeeRepository.findById(id);
		return findById.get();
	}
	@Override
	public List<Employee> findByAllEmployee(List<Integer> emp) {
		List<Employee> findAllById = emplyeeRepository.findAllById(emp);
		return findAllById;
	}
	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> findAll = emplyeeRepository.findAll();
		return findAll;
	}
	@Override
	public String deleteEmployeeById(int id) {
		boolean existsById = emplyeeRepository.existsById(id);
		if(existsById)
		{
			emplyeeRepository.deleteById(id);
			return "Record delete Successfully";
		}
			
		
		else
		{
		   return "Record not delete Successfully";
		}
	}
	@Override
	public boolean updateEmployee(Employee emp) {
		Employee save = emplyeeRepository.save(emp);
		if(save!=null)
		{
			return true;
			
		}
		else
		{
		return false;
		}
	}
	@Override
	public String deleteEmployeeAll() {
		List<Employee> findAll = emplyeeRepository.findAll();
		if(findAll.isEmpty())
		{
			return "Record not deleted";
		}
		else
		{
			emplyeeRepository.deleteAll();
			return "Record deleted Successfully";
		}
		
	}

}
