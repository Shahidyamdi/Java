package com.bharath.springweb;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bharath.springweb.entities.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class productrestapiApplicationTests {
	@Value("${productrestapi.service.url}")
	private String baseUrl;

	@Test
	public void testgetProduct() {
		System.out.println(baseUrl);

		RestTemplate template = new RestTemplate();
		Product product = template.getForObject(baseUrl + 1, Product.class);
		assertNotNull(product);
		assertEquals("iphone", product.getName());

	}

	@Test
	public void testcreateProduct() {

		RestTemplate template = new RestTemplate();
		Product product = new Product();
		product.setName("samsung");
		product.setDescription("Awesome");
		product.setPrice(20000);
		Product newproduct = template.postForObject(baseUrl, product, Product.class);
		assertNotNull(newproduct);
		assertNotNull(newproduct.getId());
		assertEquals("samsung", newproduct.getName());

	}

	@Test
	public void testupdateProduct() {

		RestTemplate template = new RestTemplate();
		Product product = template.getForObject(baseUrl + 1, Product.class);
		product.setPrice(14000);
		template.put(baseUrl, product);

	}

}