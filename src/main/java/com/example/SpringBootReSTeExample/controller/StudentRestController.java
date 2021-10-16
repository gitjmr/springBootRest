package com.example.SpringBootReSTeExample.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootReSTeExample.model.Exam;
import com.example.SpringBootReSTeExample.model.ExamResult;
import com.example.SpringBootReSTeExample.model.Student;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@RequestMapping("/fetch")
	public Student findOneStudent()
	{
		System.out.println("inside fetch method");
		return new Student(1,"Janardhana",5000.0);
	}
	
	@GetMapping("/all")
	public List<Student> findAllStudent()
	{
		return Arrays.asList(
				new Student(55, "Ram", 500.0),
				new Student(56, "Laxman", 600.0),
				new Student(57, "Raju", 700.0));
	}
	
	@GetMapping("/result")
	public ExamResult getStudentResult()
	{
	return new ExamResult(550, "PASS", "A+", 75,
			Arrays.asList(
					new Exam("MATHS","PASS",93),
					new Exam("SOCIAL","PASS",91),
					new Exam("PHYSICS","PASS",98),
					new Exam("NS","PASS",91)), 
			
			new Student(422, "Janardhana", 660.0));
	}
	
	@GetMapping("/info")
	public Map<String,Student> getAllStudentByCodes()
	{
		return Map.of("SA-001-51200-TY", new Student(55, "JMR", 499.9),
				"SA-001-51201-TY", new Student(56, "JNR", 599.9), 
				"SA-001-51202-TY", new Student(57, "JNR", 699.9));
	}
}
