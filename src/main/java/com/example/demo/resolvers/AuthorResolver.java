package com.example.demo.resolvers;

import java.util.ArrayList;
import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {
    @Autowired
    BookRepository bookRepository;

    public List<Book> books(Author author) {
        Iterable<Book> results = this.bookRepository.findByAuthorId(author.getId());
        var books = new ArrayList<Book>();
        for (Book book : results) {
            books.add(book);
        }
        return books;
    }
}