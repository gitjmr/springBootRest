package com.example.SpringBootReSTeExample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam {

	private String subName;
	
	private String result;
	
	private Integer marks;
	
	
}
