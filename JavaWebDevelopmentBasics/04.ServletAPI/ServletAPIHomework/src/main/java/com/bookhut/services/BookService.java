package com.bookhut.services;

import com.bookhut.models.binding_models.AddBookModel;
import com.bookhut.models.view_models.ViewBookModel;

import java.util.Collection;

public interface BookService {

    void saveBook(AddBookModel book);

    Collection<ViewBookModel> getAllBooks();

    ViewBookModel findBookByTitle(String title);

    void deleteBookByTitle(String title);
}
