package com.example.Repository;

import com.example.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findByName(String name);

}
