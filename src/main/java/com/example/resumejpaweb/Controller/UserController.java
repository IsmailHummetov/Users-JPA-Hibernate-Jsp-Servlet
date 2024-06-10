package com.example.resumejpaweb.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ResumeJpaDb.Dao.Inter.UserDaoInter;
import ResumeJpaDb.Entity.User;
import ResumeJpaDb.Main.Context;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", value = "/users")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDaoInter userDao = Context.instanceUserDao();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        List<User> users = userDao.getByNameSurname(firstname, lastname);
        request.setAttribute("users",users);
        request.getRequestDispatcher("users.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
