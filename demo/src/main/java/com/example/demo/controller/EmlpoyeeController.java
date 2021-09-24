package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mathutils.MathCalcuation;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmlpoyeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return "Employee Added Successfully";
	}
	
	//get the details of all the employee
	@GetMapping("/employee/{pageNo}/{pageSize}/{order}")
	public List<Employee> getAllEmployee(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize, @PathVariable("order") String order){
		return employeeService.getAllEmployee(pageNo, pageSize, order); //return all the employee details
	}
	
	//get the employee details by id
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int id){
		System.out.println(new MathCalcuation().calculation(2,3));
		return employeeService.getEmployee(id);
		
	}
	
	//delete employee by id
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		System.out.println(new MathCalcuation().mulCalculation(4,4));
		employeeService.deleteEmployee(id);
		return "Employee deleted Successfully";
	}
	
	@PutMapping("/employee/{id}")
	public String updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee) {
		return employeeService.updateEmployee(id,employee);
		//return "Employee updated Successfully";
	}
	
	@GetMapping("/employee/sumOfSalary")
	public Long getSumOfSalary() {
		return employeeService.getSumOfSalary();
	}

}
