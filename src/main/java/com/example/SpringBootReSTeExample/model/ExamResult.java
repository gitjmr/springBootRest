package com.example.SpringBootReSTeExample.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamResult {

	private Integer id;
	
	private String result;
	
	private String grade;
	
	private Integer totalMarks;
	
	private List<Exam> data;
	
	private Student student;
	
	
}
