package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.model.ProductDTO;
import com.pms.service.IProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
public class ProductRestController {
	@Autowired
	IProductService  service;
	
	@ApiOperation("Returns the details of all products")
	@ApiResponses( {
		@ApiResponse(code=200, message="Fetched the products successfully"),
		@ApiResponse(code=404, message="Request url is wrong")
	})
	@GetMapping(value="/allProducts", produces="application/json")
	public ResponseEntity<List<ProductDTO>>  findAllProducts() {
		List<ProductDTO>  productDTOList=service.searchAllProducts();
		return new ResponseEntity<List<ProductDTO>>(productDTOList, HttpStatus.OK);
	}
	
	@ApiOperation("Returns the details of a specific product")
	@GetMapping(value="/product/{id}", produces= {"application/json"})
	public  ProductDTO  findProductById(@PathVariable Integer id) {
		return service.searchProductById(id);
	}
	
	@ApiOperation("Returns the details of products based on manufacturer")
	@GetMapping(value="/products/{manufacturer}", produces="application/json")
	public List<ProductDTO>  findProductsByManufacturer(@PathVariable String manufacturer) {
		return service.searchProductsByManufacturer(manufacturer);	
	}
	
	@ApiOperation("adds a new product")
	@PostMapping(value="/product/add", consumes="application/json")
	public String addProduct(@ApiParam("a product details in json format")@RequestBody ProductDTO productDTO) {
		return service.addProduct(productDTO);		
	}
	
	@ApiOperation("updates an existing product")
	@PutMapping(value="/product/update", consumes="application/json")
	public  String  updateProduct(@ApiParam("a product details in json format") @RequestBody ProductDTO productDTO) {
		ProductDTO dto=service.updateProduct(productDTO);
		if(dto==null) {
			return "product doesn't exist";
		}
		else {
			return "product is updated";
		}
	}
	@ApiOperation("deletes a product by id")
	@DeleteMapping(value="/product/delete/{id}")
	public String deleteProductById(@PathVariable Integer id) {
		return service.deleteProductById(id);
	}

}
