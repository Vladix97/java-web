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

@WebServlet(name = "delete-book", value = "/shelves/delete/*")
public class DeleteBook extends HttpServlet {

    private BookService bookService;

    public DeleteBook() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tokens[] = req.getRequestURI().split("/");
        String title = URLDecoder.decode(tokens[3], "UTF-8");
        this.bookService.deleteBookByTitle(title);

        resp.sendRedirect("/shelves");
    }
}
