package com.bookhut.controllers;

import com.bookhut.models.view_models.ViewBookModel;
import com.bookhut.serviceImpls.BookServiceImpl;
import com.bookhut.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "edit-book", value = "/shelves/edit/*")
public class EditBook extends HttpServlet {

    private BookService bookService;

    public EditBook() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HERE " + req.getRequestURL());
        String bookTitle = URLDecoder.decode(req.getRequestURI().split("/")[3], "UTF-8");
        ViewBookModel bookByTitle = this.bookService.findBookByTitle(bookTitle);
        req.setAttribute("book", bookByTitle);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
