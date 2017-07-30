package com.bookhut.repositories;

import com.bookhut.entities.Book;

import java.util.Collection;

public interface BookRepository {

    void saveBook(Book book);

    Collection<Book> getAllBooks();

    Book findBookByTitle(String title);

    void deleteBookByTitle(String title);
}
