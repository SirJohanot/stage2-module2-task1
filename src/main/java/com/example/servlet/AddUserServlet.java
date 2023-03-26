package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {

    private static final String ADD_PAGE_PATH = "/jsp/add.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(ADD_PAGE_PATH)
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        User newUser = new User(firstName, lastName);

        Warehouse.getInstance()
                .addUser(newUser);

        req.setAttribute("user", newUser);

        req.getRequestDispatcher(ADD_PAGE_PATH)
                .forward(req, resp);
    }
}
