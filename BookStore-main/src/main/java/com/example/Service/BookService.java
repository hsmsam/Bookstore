package com.example.Service;

import com.example.Entity.Book;
import com.example.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;


    public Book saveProduct(Book product)
    {
        return repository.save(product);
    }

    public List<Book> getProducts()
    {
        return repository.findAll();
    }

    public Book getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Book> getProductByIds(List<Integer>lisOfIds) {
        return  repository.findAllById(lisOfIds);
    }
    public String updateProduct(Book book)
    {
        Optional<Book> bookFromDb =  repository.findById(book.getId());
        if(bookFromDb.isPresent())
        {
            if(book.getName()!=null) {
                bookFromDb.get().setName(book.getName());
            }
           if(book.getQuantity()>=0) {
               bookFromDb.get().setQuantity(book.getQuantity());
           }
            if(book.getPrice()>=0) {
                bookFromDb.get().setPrice(book.getPrice());
            }

            repository.save(bookFromDb.get());
            return book.getId() + " is Updated";
        }

        return book.getId() + " is not found";
    }
    public Book getproductByname(String name)
    {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

}
