package com.privalia.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.privalia.domain.Product;
import com.privalia.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ProductRepository productRepository;
	
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public Iterable<Product> listAllProducts() {
		logger.debug("listAllProducts called");
		return productRepository.findAll();
	}
	
	@Override
	public Product getProductById(Integer id) {
		logger.debug("getProductById called");
		return productRepository.findOne(id);
	}
	
	@Override
	public Product saveProduct(Product product) {
		logger.debug("saveProduct called");
		return productRepository.save(product);
	}


	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		logger.debug("deleteProduct called");
		productRepository.delete(id);
	}}
