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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductRestController {
	
	@Autowired
	IProductService iService;
	
	@ApiOperation("Returns the Details of all Poducts")
	@ApiResponses({
		@ApiResponse(code=200,message="Fetched the Products Succesfully"),
		@ApiResponse(code=404,message="Bad Request")
	})
	@GetMapping("/product/allProducts")
	public ResponseEntity<List<ProductDTO>> findAllProducts()
	{
		List<ProductDTO> productDTOlist=iService.searchAllProducts();
		
		
		return new ResponseEntity<List<ProductDTO>>(productDTOlist,HttpStatus.OK);
		
	}
	@ApiOperation("Returns Products based on Id")
	@GetMapping("/product/add/{id}")
	public ProductDTO findProductsById(@PathVariable Integer id)
	{
		
		
		
		return iService.searchProductById(id);
		
	}
	@ApiOperation("Returns Products based on manufacturer")
	@GetMapping("/product/{manufacturer}")
	public List<ProductDTO> findProductsByManufacturer(@PathVariable String manufacturer)
	{
		return iService.searchProductsByManufacturer(manufacturer);
	//	return new ResponseEntity<List<ProductDTO>> (list,HttpStatus.OK);
	}
	@ApiOperation("Adds a new Product")
	@PostMapping(value="/product/add",consumes="application/json")
	public String addProduct(@RequestBody ProductDTO productDTO)
	{
		return iService.addProduct(productDTO);
		
	}
	@ApiOperation("Updates a Product")
	@PutMapping(value="/product/update",consumes="application/json")
	public String updateProduct(@RequestBody ProductDTO productDTO)
	{
		ProductDTO dto=iService.updateProduct(productDTO);
		if(dto==null)
		{
			return "Product doesn't exist";
		}
		else 
		{
			return "Product is updated";
		}
	}
	@ApiOperation("Deletes a product using ID ")
	@DeleteMapping(value="/product/delete/{id}")
	public String deleteProduct(@PathVariable Integer id)
	{
		return iService.deleteProductById(id);
	}

}
