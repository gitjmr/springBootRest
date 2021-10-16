package com.example.SpringBootReSTeExample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

	private Integer id;
	
	private String code;
	
	private String location;
	
}
