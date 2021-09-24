package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Training;
import com.example.demo.repository.TrainingRepository;

@Service
public class TrainingService {
	
	@Autowired
	private TrainingRepository trainingRepository;

	public void save(Training training) {
		trainingRepository.save(training);
		
	}

	public List<Training> getAllTraining() {
		return trainingRepository.findAll();
	}

	public Training getTraining(int id) {
Optional<Training> optdep =trainingRepository.findById(id);
		
		return optdep.isPresent() ?   optdep.get() : null;
	}

	public String deleteTraining(int id) {
Optional<Training> optEmp = trainingRepository.findById(id);
		
		if(optEmp.isPresent()) {
			trainingRepository.deleteById(id);
			return "Course deleted Successfully with id"+id;
			}
			return "Course is not present with Id"+id;
		
	}

	public String updateTraining(int id, Training training) {
		Optional<Training> optEmp = trainingRepository.findById(id);
		if(optEmp.isPresent()) {
			Training emp = optEmp.get();
			emp.setCourse(training. getCourse());
			trainingRepository.save(emp);
			return "Course Updated Successfully with id"+id;
		}
		else {
			return "Course not present with id"+id;
		}
	}

}
