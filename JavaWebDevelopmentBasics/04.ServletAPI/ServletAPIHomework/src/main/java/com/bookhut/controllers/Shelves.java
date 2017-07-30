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
import java.util.Collection;

@WebServlet(name = "shelves", value = "/shelves")
public class Shelves extends HttpServlet {

    private BookService bookService;

    public Shelves() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<ViewBookModel> allBooks = this.bookService.getAllBooks();
        req.setAttribute("books", allBooks);
        req.getRequestDispatcher("templates/shelves.jsp").forward(req, resp);
    }
}
