package com.example.SpringBootReSTeExample.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {

	private Integer bookId;
	private String bookName;
	private Double bookCost;
	private List<String> authors;
	private Map<String, String> versions;
	
	public Publisher pob;
}
