package com.capgemini.springproject.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springproject.dto.ProductInfo;
import com.capgemini.springproject.dto.ProductResponse;
import com.capgemini.springproject.service.ProductService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping(path = "/add-product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse addProduct(@RequestBody ProductInfo product) {
		ProductResponse response = new ProductResponse();
		if (service.addProduct(product)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product added");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product with same name already exists");
		}
		return response;
	}

	@GetMapping(path = "/view-product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse viewProduct(@RequestParam("id") int id) {
		ProductResponse response = new ProductResponse();
		ProductInfo product = service.getProduct(id);
		if (product != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product found");
			response.setProduct(Arrays.asList(product));
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product id does not exist");
		}
		return response;
	}

	@GetMapping(path = "/view-allproducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse viewAllProducts() {
		ProductResponse response = new ProductResponse();
		List<ProductInfo> list = service.getAllProducts();
		if (list.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Products found");
			response.setProduct(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No data");
		}
		return response;

	}

	@DeleteMapping(path = "/delete-product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse deleteProduct(@PathVariable("id") int id) {
		ProductResponse response = new ProductResponse();
		if (service.deleteProduct(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product deleted");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product not found");
		}
		return response;
	}

	@PutMapping(path = "/modify-product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse modifyProduct(@RequestBody ProductInfo product) {
		ProductResponse response = new ProductResponse();
		if (service.modifyProduct(product.getId())) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Product cost updated");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Product not found");
		}
		return response;
	}

}
