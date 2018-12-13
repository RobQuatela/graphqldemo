package com.example.demo.types;

import java.util.List;

public class AuthorDto {
    private String name;
    private List<BookDto> books;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the books
     */
    public List<BookDto> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}