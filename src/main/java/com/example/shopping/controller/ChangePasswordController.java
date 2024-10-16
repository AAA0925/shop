package com.example.shopping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.shopping.dao.SellerDAO;

@WebServlet("/change-password")
public class ChangePasswordController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String username = (String) request.getSession().getAttribute("seller");

        SellerDAO sellerDAO = new SellerDAO();
        if (sellerDAO.changePassword(username, oldPassword, newPassword)) {
            response.sendRedirect("admin.jsp?success=changed");
        } else {
            response.sendRedirect("admin.jsp?error=invalid");
        }
    }
}

