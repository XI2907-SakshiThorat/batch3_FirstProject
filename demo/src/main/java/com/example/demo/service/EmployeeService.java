package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service

public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void save(Employee employee) {
		employeeRepository.save(employee);
		//empList.add(employee); // To add employee
	}

	public List<Employee> getAllEmployee(int pageNo, int pageSize, String order) {
		
		Pageable pageable = PageRequest.of(pageNo,pageSize,order.equals("asc") ? Sort.by("name").ascending() : Sort.by("name").descending());
		Page<Employee> page = employeeRepository.findAll(pageable);
		return page.toList();
		
		//return empList; //return all the employee details
		//return employeeRepository.findAll();
	}

	public Employee getEmployee(int id) {
		
		Optional<Employee> optEmp = employeeRepository.findById(id);
		//Optional<Employee> optEmp = empList.stream().filter(emp -> emp.getId() == id).findAny();
		Employee e = optEmp.isPresent() ? optEmp.get():null;
		e.setName(e.getName()+ "Changed");
		return e;
	}

	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> optEmp = employeeRepository.findById(id);
		//empList.removeIf(emp -> emp.getId() == id);
		if(optEmp.isPresent()) {
			employeeRepository.deleteById(id);
			return "Employee deleted Successfully with id"+id;
			}
			return "Employee is not present with Id"+id;
		
		
	}

	public String updateEmployee(int id, Employee employee) {
		Optional<Employee> optEmp = employeeRepository.findById(id);
		if(optEmp.isPresent()) {
			Employee emp = optEmp.get();
			emp.setName(employee. getName());
			emp.setSalary(employee.getSalary());
			employeeRepository.save(emp);
			return "Employee Updated Successfully with id"+id;
		}
		else {
			return "Employee not present with id"+id;
		}
		
		
		
		
		
		// TODO Auto-generated method stub
//		for(int i=0; i<empList.size(); i++) {
	//		if(empList.get(i).getId() == id) {
		//		empList.set(i, employee);
			//	break;
			//}
		//}
	}

	public Long getSumOfSalary() {
		return employeeRepository.getSumOfSalary();
	}


	
	



}
