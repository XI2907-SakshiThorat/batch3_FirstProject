package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping
	public String hello(){
		return "Hello";
}
	
	@GetMapping("/Hello/{name}")
	public String greet(@PathVariable("name") String name){
		return "Hello" +name ;
	}
}
