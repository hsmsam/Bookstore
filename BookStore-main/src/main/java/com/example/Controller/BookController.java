package com.example.Controller;


import com.example.Entity.Book;
import com.example.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService service;

    // Create APi
    @PostMapping("/addBook")
    public Book addProduct(@RequestBody Book book) {
        return service.saveProduct(book);
    }

    // Read Api
    @GetMapping("/getAllBooks")
    public List<Book> findAllProducts() {
        return service.getProducts();
    }
    // Read Api By Name
    @GetMapping("/bookByName/{name}")
    public Book findProductByName(@PathVariable  String name) {
        return service.getproductByname(name);
    }
    // Read Api By ID
    @GetMapping("/bookById/{id}")
    public  Book findProductById(@PathVariable int id)
    {
        return  service.getProductById(id);
    }
    // Fetch By List of Ids:
    @PostMapping("/booksByIds")
    public List<Book> getProductByIds(@RequestBody List<Integer> listOfIds) {
        return service.getProductByIds(listOfIds);
    }
    // Delete Api
    @DeleteMapping("/deleteBook/{id}")
    public  String deleteProduct(@PathVariable int id)
    {
        return service.deleteProduct(id);
    }
    // Update APi
    @PutMapping("/updateBook")
    public String updateProduct(@RequestBody Book book)
    {
        return service.updateProduct(book);
    }


}
