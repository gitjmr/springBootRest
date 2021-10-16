package com.example.SpringBootReSTeExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootReSTeExample.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	

}
