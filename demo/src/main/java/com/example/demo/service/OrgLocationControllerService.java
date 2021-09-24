package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.OrgLocation;
import com.example.demo.repository.OrgLocationRepository;

@Service
public class OrgLocationControllerService {
	
	@Autowired
	private OrgLocationRepository orgLocationRepository;


	public void save(OrgLocation orgLocation) {
		orgLocationRepository.save(orgLocation);
		
	}

	public List<OrgLocation> getAllOrgLocation() {
		return orgLocationRepository.findAll();
	}

	public OrgLocation getOrgLocation(int id) {
Optional<OrgLocation> optdep =orgLocationRepository.findById(id);
		
		return optdep.isPresent() ?   optdep.get() : null;
	}

	public String deleteOrgLocation(int id) {
Optional<OrgLocation> optEmp = orgLocationRepository.findById(id);
		
		if(optEmp.isPresent()) {
			orgLocationRepository.deleteById(id);
			return "orgLocation deleted Successfully with id"+id;
			}
			return "orgLocation is not present with Id"+id;
		
	}

	public String updateOrgLocation(int id, OrgLocation orgLocation) {
		Optional<OrgLocation> optEmp = orgLocationRepository.findById(id);
		if(optEmp.isPresent()) {
			OrgLocation emp = optEmp.get();
			emp.setTowerno(orgLocation. getTowerno());
			emp.setFloorno(orgLocation. getFloorno());
			emp.setSeatno(orgLocation.getSeatno());
			orgLocationRepository.save(emp);
			return "OrgLocation Updated Successfully with id"+id;
		}
		else {
			return "OrgLocation not present with id"+id;
		}
	}
	}


