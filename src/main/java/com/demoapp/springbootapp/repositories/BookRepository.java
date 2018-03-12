package com.demoapp.springbootapp.repositories;

import com.demoapp.springbootapp.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
