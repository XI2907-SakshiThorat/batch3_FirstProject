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

import com.example.demo.entity.OrgLocation;
import com.example.demo.service.OrgLocationControllerService;

@RestController
@RequestMapping("/api")
public class OrgLocationController {
	
	@Autowired
	private OrgLocationControllerService orgLocationControllerService;
	
	@PostMapping("/orgLocation")
	public String addOrgLocation(@RequestBody OrgLocation orgLocation) {
		orgLocationControllerService.save(orgLocation);
		return "course Added Successfully";
	}
	
	@GetMapping("/orgLocation")
	public List<OrgLocation> getAllOrgLocation(){
		return  orgLocationControllerService.getAllOrgLocation(); //return all the employee details
	}
	
	//get the employee details by id
	@GetMapping("/orgLocation/{id}")
	public OrgLocation getOrgLocation(@PathVariable("id") int id){
		return  orgLocationControllerService.getOrgLocation(id);
		
	}
	
	//delete employee by id
	@DeleteMapping("/orgLocation/{id}")
	public String deleteOrgLocation(@PathVariable("id") int id) {
		 orgLocationControllerService.deleteOrgLocation(id);
		return "course deleted Successfully";
	}
	
	@PutMapping("/orgLocation/{id}")
	public String updateOrgLocation(@PathVariable("id") int id,@RequestBody OrgLocation orgLocation) {
		return  orgLocationControllerService.updateOrgLocation(id,orgLocation);
		//return "Employee updated Successfully";
	}

}
