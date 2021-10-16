package com.example.SpringBootReSTeExample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prod_tab")
@Getter
@Setter
public class Product {

	@Column(name = "prod_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prodId;
	
	@Column(name="prod_code")
	private String prodCode;
	
	@Column(name="prod_cost")
	private Double prodCost;
	
	@Column(name="prod_vendor")
	private String prodVendor;
	
}
