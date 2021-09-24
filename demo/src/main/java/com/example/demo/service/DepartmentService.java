package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentRepository.save(department);
		
	}

	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	public Department getDepartment(int id) {
		Optional<Department> optdep =departmentRepository.findById(id);
		
		return optdep.isPresent() ?   optdep.get() : null;
	}

	public String deleteDepartment(int id) {
		Optional<Department> optEmp = departmentRepository.findById(id);
		
		if(optEmp.isPresent()) {
			departmentRepository.deleteById(id);
			return "Department deleted Successfully with id"+id;
			}
			return "Department is not present with Id"+id;
		
	}

	public String updateDepartment(int id, Department department) {
		Optional<Department> optEmp = departmentRepository.findById(id);
		if(optEmp.isPresent()) {
			Department emp = optEmp.get();
			emp.setDeptname(department. getDeptname());
			departmentRepository.save(emp);
			return "Department Updated Successfully with id"+id;
		}
		else {
			return "Department not present with id"+id;
		}
	}

	

}
