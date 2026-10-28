//package com.tvo.productservice;
//
//import com.tvo.productservice.dto.ProductResponse;
//import com.tvo.productservice.model.Product;
//import com.tvo.productservice.repository.ProductRepository;
//import com.tvo.productservice.service.ProductService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//class ProductServiceApplicationTests {
//
//	@Mock
//    ProductRepository repository;
//
//	@InjectMocks
//    ProductService service;
//
//	@Test
//	void shouldReturnProducts() {
//
//		when(repository.findByCustomerId("123"))
//				.thenReturn(List.of(
//						new Product(
//								"123",
//								"P100",
//								"Account")));
//
//		List<ProductResponse> result =
//				service.getProducts("123");
//
//		assertEquals(1,result.size());
//	}
//}
//
