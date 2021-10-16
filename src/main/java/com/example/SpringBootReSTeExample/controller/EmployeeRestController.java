package com.example.SpringBootReSTeExample.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@PostMapping("/save")
	public String createEmployee()

	{

		return "EMPLOYEE-POST";
	}

	@GetMapping("/show")
	public String fetchEmployee() {

		if (new Random().nextInt(100) < 100)
			throw new RuntimeException("DUMMY");

		return "EMPLOYEE-GET";
	}

	@PutMapping("/modify")
	public String updateEmployee() {
		return "EMPLOYEE-PUT";
	}

	@DeleteMapping("/remove")
	public String rmoveEmployee() {
		return "EMPLOYEE-DELETE";
	}

	@PatchMapping("/modifyEmail")
	public String updateEmployeeEmail() {
		return "EMPLOYEE-PATCH";
	}
}
