package com.example.shopping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.shopping.dao.SellerDAO;

@WebServlet("/seller-login")
public class SellerLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        SellerDAO sellerDAO = new SellerDAO();
        if (sellerDAO.validateSeller(username, password)) {
            request.getSession().setAttribute("seller", username);
            response.sendRedirect("admin.jsp");
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
