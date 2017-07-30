package com.bookhut.controllers;

import com.bookhut.models.binding_models.LoginUserModel;
import com.bookhut.serviceImpls.UserServiceImpl;
import com.bookhut.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sign-up", value = "/sign-up")
public class SignUp extends HttpServlet {

    private UserService userService;

    public SignUp() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("templates/sign-up.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("") || password.equals("")) {
            req.getRequestDispatcher("templates/sign-up.jsp").forward(req, resp);
        }

        LoginUserModel user = new LoginUserModel(username, password);
        this.userService.createUser(user);
        resp.sendRedirect("/sign-in");
    }
}
