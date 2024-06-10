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

@WebServlet(name = "UserDelete", value = "/userdelete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.parseInt(request.getParameter("id"));
        UserDaoInter userDao = Context.instanceUserDao();
        User u = userDao.getbyId(userId);
        userDao.deleteUser(userId);
        response.sendRedirect("users");
    }
}
