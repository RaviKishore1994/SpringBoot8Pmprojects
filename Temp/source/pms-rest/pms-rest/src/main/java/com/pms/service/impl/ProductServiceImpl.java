package com.pms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.pms.entity.Product;
import com.pms.model.ProductDTO;
import com.pms.repository.ProductRepository;
import com.pms.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository pr;
	
	@Override
	public List<ProductDTO> searchAllProducts() {
		
		List<Product> productList=pr.findAll();
		List<ProductDTO> dtolist=new ArrayList<ProductDTO>();
		productList.forEach(product->{
			ProductDTO dto=new ProductDTO();
			BeanUtils.copyProperties(product, dto);
			dtolist.add(dto);
			
			
		});
		
		return dtolist;
	}

	@Override
	public ProductDTO searchProductById(Integer id) {
		
		Optional opt=pr.findById(id);
		if(opt.isPresent())
		{
			Product product=(Product) opt.get();
			ProductDTO productDTO=new ProductDTO();
			BeanUtils.copyProperties(product, productDTO);
			return productDTO;
			
		}
		
		
		return null;
	}

	@Override
	public List<ProductDTO> searchProductsByManufacturer(String manufacturer) {
		List<Product> productList=pr.findByManufacturer(manufacturer);
		List<ProductDTO> dtolist=new ArrayList<ProductDTO>();
		productList.forEach(product->{
			ProductDTO dto=new ProductDTO();
			BeanUtils.copyProperties(product, dto);
			dtolist.add(dto);
			
			
		});
		
		return dtolist;
	}

	@Override
	public String addProduct(ProductDTO productDTO) {
		Product product=new Product();
		BeanUtils.copyProperties(productDTO, product);
		if(pr.existsById(product.getProductId()))
		{
			return "Product Id is ALready exists";
		}
		else
		{
		 pr.save(product);
		 return "Product is added to database";
		}
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {
		Product product=new Product();
		BeanUtils.copyProperties(productDTO, product);
		if(pr.existsById(product.getProductId()))
		{
			pr.saveAndFlush(product);
			return productDTO;
		}
		return null;
	}

	@Override
	public String deleteProductById(Integer id) {
		Product product=new Product();
		
		if(pr.existsById(id))
		{
		pr.deleteById(id);	
		return "Deleted Successfully";
		}
		else
		{
		return "The given Id is not exist to delete";
		}
	}
	
}
