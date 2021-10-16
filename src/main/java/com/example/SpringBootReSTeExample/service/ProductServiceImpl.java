package com.example.SpringBootReSTeExample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootReSTeExample.entity.Product;
import com.example.SpringBootReSTeExample.exception.ProductNotFoundException;
import com.example.SpringBootReSTeExample.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodRepo;

	@Override
	public Integer saveProduct(Product prod) {

		return prodRepo.save(prod).getProdId();

	}

	@Override
	public Product getOneProduct(Integer id) {

		Optional<Product> opt = prodRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();

		} else {
			throw new ProductNotFoundException("Product not found with the Id " + id);
		}
	}

	@Override
	public List<Product> getAllProducts() {

		return prodRepo.findAll();

	}

	@Override
	public void deleteProduct(Integer id) {

		if (getOneProduct(id).getProdId() == null) {
			throw new ProductNotFoundException("Product not found with the Id " + id);
		} else {
			prodRepo.deleteById(id);
		}

	}

	@Override
	public void updateProduct(Product prod) {

		if (getOneProduct(prod.getProdId()) == null) {
			throw new ProductNotFoundException("Product not exists with Id " + prod.getProdId());
		} else {
			prodRepo.save(prod);
		}
	}

}
