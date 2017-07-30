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

@WebServlet(name = "sign-in", value = "/sign-in")
public class SignIn extends HttpServlet {

    private UserService userService;

    public SignIn() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("templates/sign-in.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        LoginUserModel user = this.userService.findUserByUsernameAndPassword(username, password);
        if (user == null) {
            req.getRequestDispatcher("templates/sign-in.jsp").forward(req, resp);
        }

        req.getSession().setAttribute("user", user);
        resp.sendRedirect("/");
    }
}
