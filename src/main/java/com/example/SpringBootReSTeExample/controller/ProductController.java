package com.example.SpringBootReSTeExample.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootReSTeExample.entity.Product;
import com.example.SpringBootReSTeExample.exception.ProductNotFoundException;
import com.example.SpringBootReSTeExample.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product")
public class ProductController {

	
	private static final Logger LOGGER = LogManager.getLogger(ProductController.class);
	
	@Autowired
	private ProductService prodSer;

	@PostMapping("/save")
	@ApiOperation("saving product")
	public ResponseEntity<Integer> saveProduct(@RequestBody Product product) {
		
		LOGGER.debug("Inside save method");
		LOGGER.info("info method");
		
		System.out.println(product.getProdCode());
		System.out.println(product.getProdCost());
		System.out.println(product.getProdVendor());

		Integer id = prodSer.saveProduct(product);
		return new ResponseEntity<Integer>(id, HttpStatus.CREATED);

	}

	@GetMapping("/get/{abc}")
	public ResponseEntity<?> getProduct(@PathVariable("abc") Integer id) {

		ResponseEntity<?> resp = null;
		try {

			Product oneProduct = prodSer.getOneProduct(id);
			resp = new ResponseEntity<Product>(oneProduct, HttpStatus.OK);

		} catch (ProductNotFoundException e) {
			System.out.println(e.getMessage());
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return resp;
	}

	@RequestMapping("/getAll")
	public ResponseEntity<List<Product>> getAllProducts() {

		LOGGER.debug("Inside get All  method");
		LOGGER.info("info in get all method");
		return new ResponseEntity<List<Product>>(prodSer.getAllProducts(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id) {
		ResponseEntity<String> resp;
		try {

			prodSer.deleteProduct(id);
			resp = new ResponseEntity<String>("Product deleted with an item " + id, HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(@RequestBody Product prod) {
		ResponseEntity<String> resp = null;
		try {
			prodSer.getOneProduct(prod.getProdId());
			prodSer.updateProduct(prod);
			resp = new ResponseEntity<String>("record updated", HttpStatus.OK);

		} catch (ProductNotFoundException e) {
			resp = new ResponseEntity<String>("record not found ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
}
