package com.example.demo;

import com.example.Entity.Book;
import com.example.Service.BookService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookStoreApplicationTests {

	@Autowired
	BookService bookService;
	@DisplayName("Test Case 1: Add Book")
	@Test
	@Order(1)
	void addBook() {
		Book newBook =  new Book();
		newBook.setPrice(200);
		newBook.setName("Mr.kohli");
		newBook.setQuantity(15);

		Book resBook = bookService.saveProduct(newBook);
		Assertions.assertEquals(newBook.getName(), resBook.getName());
	}

	@Test
	@Order(2)
	@DisplayName("Test Case 2: Get All Books")
	void getBooks() {
		List<Book> resBook = bookService.getProducts();
		Assertions.assertEquals("Mr.kohli", resBook.get(0).getName());
	}

	@Test
	@Order(3)
	@DisplayName("Test Case 3: Get Book By Name")
	void getBookByName() {
		Book resBook = bookService.getproductByname("Mr.kohli");
		Assertions.assertEquals(1, resBook.getId());
	}

	@Test
	@Order(4)
	@DisplayName("Test Case 4: Get Book By Id")
	void getBookById() {
		Book resBook = bookService.getProductById(1);
		Assertions.assertEquals("Mr.kohli", resBook.getName());
	}

	@Test
	@Order(5)
	@DisplayName("Test Case 5: Get Books By Ids")
	void getBookByIds() {
		Book newBook =  new Book();
		newBook.setPrice(300);
		newBook.setName("Ramayan");
		newBook.setQuantity(25);
		Book resBook = bookService.saveProduct(newBook);
		List<Book>lisBooks = bookService.getProductByIds(Arrays.asList(1,2));
		Assertions.assertEquals("Ramayan", lisBooks.get(1).getName());
	}

	@Test
	@Order(6)
	@DisplayName("Test Case 6: Update Book")
	void updateBook() {

		Book resBook = bookService.getproductByname("Mr.kohli");
		String res = bookService.updateProduct(resBook);
		Assertions.assertEquals("1 is Updated", res);
	}

	@Test
	@Order(7)
	@DisplayName("Test Case 7: Delete Book")
	void DeleteBook() {

		String res = bookService.deleteProduct(1);
		Assertions.assertEquals("product removed !! 1", res);
	}







}
