package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;



@Repository												//Table, Primary key from that table
public interface DepartmentRepository extends JpaRepository<Department, Integer>  {

}
