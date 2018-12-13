package com.example.demo.repositories;

import com.example.demo.models.Book;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Query("select b from Book b where b.author.id = ?1")
    public Iterable<Book> findByAuthorId(long authorId);
}