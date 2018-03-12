package com.demoapp.springbootapp.repositories;

import com.demoapp.springbootapp.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {



}
