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

@WebServlet(name = "UserDetailController", value = "/userdetail")
public class UserDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                throw new IllegalArgumentException("id is not specified");
            }
            Integer userId = Integer.parseInt(userIdStr);
            UserDaoInter userDao = Context.instanceUserDao();
            User u = userDao.getbyId(userId);
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id");
            }
            request.setAttribute("user", u);
            request.getRequestDispatcher("userdetail.jsp").forward(request, response);


        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error?msg=" + ex.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
