package com.bookhut.repositoryImpls;

import com.bookhut.entities.Book;
import com.bookhut.repositories.BookRepository;

import java.util.*;

public class BookRepositoryImpl implements BookRepository {

    private static BookRepositoryImpl bookRepository;

    private Map<String, Book> books;

    private BookRepositoryImpl() {
        this.books = new LinkedHashMap<>();
    }

    public static BookRepository getInstance() {
        if (BookRepositoryImpl.bookRepository == null) {
            BookRepositoryImpl.bookRepository = new BookRepositoryImpl();
        }

        return BookRepositoryImpl.bookRepository;
    }

    @Override
    public void saveBook(Book book) {
        this.books.put(book.getTitle(), book);
    }

    @Override
    public Collection<Book> getAllBooks() {
        return this.books.values();
    }

    @Override
    public Book findBookByTitle(String title) {
        return this.books.get(title);
    }

    @Override
    public void deleteBookByTitle(String title) {
        this.books.remove(title);
    }
}
