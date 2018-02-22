package com.privalia.repositories;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.privalia.configuration.RepositoryConfiguration;
import com.privalia.domain.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RepositoryConfiguration.class}) 
public class ProductRepositoryTest  { 

	@Rule
	public TestName testName = new TestName();

	
    public static final Logger LOGGER = LoggerFactory.getLogger(ProductRepositoryTest.class);
	
	private ProductRepository productRepository;
	private Product product1 = null;
	private Product product2 = null;
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Before
	public void setUp() throws Exception {
		product1 = new Product();
		product1.setDescription("Privalia Spring Framework");
		product1.setPrice(new BigDecimal("21.95"));
		product1.setProductId("1232");
		productRepository.save(product1);
		
		product2 = new Product();
		product2.setDescription("Privalia Hibernate Framework");
		product2.setPrice(new BigDecimal("23.85"));
		product2.setProductId("1233");
		productRepository.save(product2);	
		
		LOGGER.info("Started Test " + this.testName.getMethodName());
	}
	
	@After
	public void after() throws Exception {
		productRepository.deleteAll();
		
		LOGGER.info("Started Test " + this.testName.getMethodName());
	}
	
	@Test
	public void testSaveProduct() {
		
		Product product = new Product();
		
		product.setDescription("Blu Ray Woody Allen");
		product.setPrice(new BigDecimal("23.99"));
		product.setProductId("6969");
		
		assertNull(product.getId());
		productRepository.save(product);
		
		assertNotNull(product.getId());
	}
	
	@Test
	public void testGetAllProducts() {
		Iterable<Product> products = productRepository.findAll();
		long size = products.spliterator().getExactSizeIfKnown();
		assertEquals(size, 2);
		
	}
	
	@Test
	public void testModifyProduct() { 
		//No haría falta con el TestName
		//LOGGER.info("Start testModifyProduct Method");
		
		product1.setDescription("New description");
		Product updateProduct = productRepository.save(product1);
		assertEquals(updateProduct.getDescription(), "New description");
		
		//No haría falta con el TestName
		LOGGER.info("Finish testModifyProduct Method");
	}
	
	@Test 
	public void testRemoveProduct() {
		productRepository.delete(product1.getId());
		assertNull(productRepository.findOne(product1.getId()));
	}
	
	@Test 
	//@Ignore
	public void testFindByProductId() {
		
		assertNotNull(productRepository.findByProductId(product1.getProductId()));

	}
	
	@Test
	public void testFindByDescriptionAndPrice() {
		assertNotNull(productRepository.findByDescriptionAndPrice(
				product1.getDescription(),
				product1.getPrice()));
//				"Privalia Hibernate Framework", 
//				new BigDecimal("23.85")));
		
	}
	
	@Test
	public void testUpdateProduct() {
		
		LOGGER.info("Start testUpdateProduct Method");
		assertEquals(
				productRepository.updateProduct(product1.getId(), "JareJareNow!"),
				1
				);
		LOGGER.info("End testUpdateProduct Method");
	}
	

	
//	@Test
//	public void testFindByDescription() {
//		List<Product> product= productRepository.findByDescription("New description");
//		assertNotNull(product.get(0));
//		assertEquals(product.get(0), "New description");
//	}
}
