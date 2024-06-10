package com.example.resumejpaweb.Controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ResumeJpaDb.Dao.Inter.UserDaoInter;
import ResumeJpaDb.Entity.User;
import ResumeJpaDb.Main.Context;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            UserDaoInter userDao = Context.instanceUserDao();
            if (userDao.getByEmail(email).getPassword() == null) {
                response.sendRedirect("login");
                throw new IllegalArgumentException("There is no user with this email");
            } else {

                String pass = userDao.getByEmail(email).getPassword();
                BCrypt.Verifyer verifyer = BCrypt.verifyer();
                BCrypt.Result rs = verifyer.verify(password.toCharArray(), pass.toCharArray());
                if (rs.verified) {
                    User user = userDao.getByEmail(email);
                    request.getSession().setAttribute("loggedInUser", user);
                    response.sendRedirect("users");
                } else {
                    response.sendRedirect("login");
                    throw new IllegalArgumentException("Password is wrong");
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

