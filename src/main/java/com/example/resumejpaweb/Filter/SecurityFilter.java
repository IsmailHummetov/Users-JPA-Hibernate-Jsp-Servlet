package com.example.resumejpaweb.Filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebFilter(filterName = "SecurityFilter", urlPatterns = {"*"})
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain){
        try {
            HttpServletResponse res = (HttpServletResponse) response;
            HttpServletRequest req = (HttpServletRequest) request;
            if (!req.getRequestURI().contains("login") && req.getSession().getAttribute("loggedInUser") == null) {
                res.sendRedirect("login");
            } else {
                filterChain.doFilter(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
