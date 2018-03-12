package com.demoapp.springbootapp.bootstrap;

import com.demoapp.springbootapp.models.Publisher;
import com.demoapp.springbootapp.repositories.PublisherRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.demoapp.springbootapp.models.Author;
import com.demoapp.springbootapp.models.Book;
import com.demoapp.springbootapp.repositories.AuthorRepository;
import com.demoapp.springbootapp.repositories.BookRepository;

@Component
public class InitBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public InitBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("New-York Times");
        publisherRepository.save(publisher);

        //First init data
        Author stivenson = new Author("Robert", "Stivenson");
        Book island = new Book("Treasure Island", "1234", publisher);
        stivenson.getBooks().add(island);
        island.getAuthors().add(stivenson);

        authorRepository.save(stivenson);
        bookRepository.save(island);

        //Second init data
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "25554", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);
    }

}
