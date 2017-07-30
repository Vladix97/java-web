package com.bookhut.serviceImpls;

import com.bookhut.entities.Book;
import com.bookhut.models.binding_models.AddBookModel;
import com.bookhut.models.view_models.ViewBookModel;
import com.bookhut.repositories.BookRepository;
import com.bookhut.repositoryImpls.BookRepositoryImpl;
import com.bookhut.services.BookService;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private ModelMapper modelMapper;

    @Override
    public void saveBook(AddBookModel book) {
        this.bookRepository = BookRepositoryImpl.getInstance();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Collection<ViewBookModel> getAllBooks() {
        Collection<Book> allBooks = this.bookRepository.getAllBooks();
        List<ViewBookModel> viewBookModels = new ArrayList<>();
        for (Book book : allBooks) {
            viewBookModels.add(this.modelMapper.map(book, ViewBookModel.class));
        }

        return viewBookModels;
    }

    @Override
    public ViewBookModel findBookByTitle(String title) {
        Book bookByTitle = this.bookRepository.findBookByTitle(title);
        return this.modelMapper.map(bookByTitle, ViewBookModel.class);
    }

    @Override
    public void deleteBookByTitle(String title) {
        this.bookRepository.deleteBookByTitle(title);
    }
}
