package com.example.demo.resolvers;

import java.util.ArrayList;
import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.models.Author;
import com.example.demo.repositories.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Query implements GraphQLQueryResolver {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> authors() {
        Iterable<Author> results = this.authorRepository.findAll();
        var authors = new ArrayList<Author>();
        for (Author author : results) {
            authors.add(author);
        }
        return authors;
    }
}