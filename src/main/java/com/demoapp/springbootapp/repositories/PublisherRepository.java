package com.demoapp.springbootapp.repositories;

import com.demoapp.springbootapp.models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
