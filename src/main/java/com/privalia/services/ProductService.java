package com.privalia.services;

import com.privalia.domain.Product;

//Interfaz fuertemente tipada
public interface ProductService {
	Iterable<Product> listAllProducts();
	
	Product getProductById(Integer id);
	
	Product saveProduct(Product product);
	
	void deleteProduct(Integer id);
}
