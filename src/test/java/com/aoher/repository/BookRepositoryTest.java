package com.aoher.repository;

import com.aoher.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJdbcTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private BookRepository repository;

    @Test
    public void testFindByName() {
        Book book = new Book("C++");
        em.persist(book);

        List<Book> books = repository.findByName(book.getName());

        assertEquals(1, books.size());
        assertThat(books).extracting(Book::getName).containsOnly(book.getName());
    }
}