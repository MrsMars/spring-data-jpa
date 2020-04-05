package com.aoher;

import com.aoher.model.Book;
import com.aoher.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    @Autowired
    private BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("StartApplication...");

        repository.save(new Book("Java"));
        repository.save(new Book("Node"));
        repository.save(new Book("Python"));

        log.info("\nfindAll()");
        repository.findAll().forEach(b -> log.info(b.toString()));

        log.info("\nfindById(1L)");
        repository.findById(1L).ifPresent(b -> log.info(b.toString()));

        log.info("\nfindByName('Node')");
        repository.findByName("Node").forEach(b -> log.info(b.toString()));
    }
}
