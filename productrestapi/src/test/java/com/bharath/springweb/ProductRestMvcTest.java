package com.bharath.springweb;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bharath.springweb.entities.Product;
import com.bharath.springweb.repos.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductRestMvcTest {

	private static final String Context_url = "/productapi";
	private static final int Product_price = 50000;
	private static final String Product_Description = "Awesome";
	private static final String Product_Name = "iphone";
	private static final int Product_id = 1;

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ProductRepository repository;

	@Value("${productrestapi.service.url}")
	private String baseUrl;

	@Test
	public void Testfindall() throws Exception {
		Product product = bulidproduct();

		List<Product> newProducts = Arrays.asList(product);
		when(repository.findAll()).thenReturn(newProducts);
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		mockMvc.perform(get(baseUrl).contextPath(Context_url)).andExpect(status().isOk())
				.andExpect(content().json(objectWriter.writeValueAsString(newProducts)));

		// "[{'id':1,name:'MacBook','description':'Awesome','price':1000}]"

	}

	@Test
	public void TestfindbyID() throws Exception {
		Product product = bulidproduct();
		when(repository.findById(Product_id)).thenReturn(java.util.Optional.of(product));
		mockMvc.perform(delete(baseUrl + Product_id).contextPath(Context_url)).andExpect(status().isOk());
	}

	private Product bulidproduct() {
		Product product = new Product();
		product.setId(1);
		product.setName(Product_Name);
		product.setDescription(Product_Description);
		product.setPrice(Product_price);
		return product;
	}

	@Test
	public void testcreateProduct() throws JsonProcessingException, Exception {
		Product product = bulidproduct();
		when(repository.save(any())).thenReturn(product);
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		mockMvc.perform(post(baseUrl).contextPath(Context_url).contentType(MediaType.APPLICATION_JSON)
				.content(objectWriter.writeValueAsString(product))).andExpect(status().isOk())
				.andExpect(content().json(objectWriter.writeValueAsString(product)));

	}

	@Test
	public void testupdateproduct() throws JsonProcessingException, Exception {
		Product product = bulidproduct();
		when(repository.save(any())).thenReturn(product);
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		mockMvc.perform(put(baseUrl).contextPath(Context_url).contentType(MediaType.APPLICATION_JSON)
				.content(objectWriter.writeValueAsString(product))).andExpect(status().isOk())
				.andExpect(content().json(objectWriter.writeValueAsString(product)));

	}

	@Test
	public void deleteProduct() throws Exception {
		doNothing().when(repository).deleteById(Product_id);
		mockMvc.perform(delete(baseUrl + Product_id).contextPath(Context_url)).andExpect(status().isOk());
	}

}
