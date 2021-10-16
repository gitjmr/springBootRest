package com.example.SpringBootReSTeExample.service;

import java.util.List;

import com.example.SpringBootReSTeExample.entity.Product;

public interface ProductService {

	public Integer saveProduct(Product prod);

	public Product getOneProduct(Integer id);

	public List<Product> getAllProducts();

	public void deleteProduct(Integer id);

	public void updateProduct(Product prod);
}
