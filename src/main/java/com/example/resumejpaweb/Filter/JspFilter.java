package com.example.resumejpaweb.Filter;

import com.example.resumejpaweb.Util.ControllerUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "JspFilter", urlPatterns = {"*.jsp"})
public class JspFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        ControllerUtil.errorPage(res,new IllegalArgumentException("JSP page not found"));
    }

}
