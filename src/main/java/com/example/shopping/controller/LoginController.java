package com.example.shopping.controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final String SELLER_PASSWORD = "your_password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //     String password = request.getParameter("password");
    //    if (SELLER_PASSWORD.equals(password)) {
    //        response.sendRedirect("admin");
    //    } else {
    //        response.sendRedirect("login.jsp?error=invalid");
    //    }
    	response.sendRedirect("admin.jsp");
    }
}
