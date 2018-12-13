package com.example.demo.resolvers;

import java.util.ArrayList;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.models.User;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.types.AuthorDto;
import com.example.demo.types.BookDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    AuthorRepository authorRepository;

    public Author createAuthor(AuthorDto authorDto) {
        var author = new Author();
        var user = new User();
        var books = new ArrayList<Book>();
        for (BookDto book : authorDto.getBooks()) {
            var b = new Book();
            b.setName(book.getName());
            books.add(b);
        }
        user.setId(1);
        author.setName(authorDto.getName());
        author.setBooks(books);
        author.setLastModifiedBy(user);

        var result = authorRepository.save(author);

        return result;
    }
}