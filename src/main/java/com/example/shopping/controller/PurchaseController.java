package com.example.shopping.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.shopping.dao.ProductDAO;

@WebServlet("/purchase")
public class PurchaseController extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long productId = Long.parseLong(request.getParameter("productId"));
        String userName = request.getParameter("userName");
        String userContact = request.getParameter("userContact");

        // 记录买家的意向
        productDAO.recordBuyerIntent(productId, userName, userContact); // 假设你在 ProductDAO 中有这个方法

        response.sendRedirect("success.jsp"); // 重定向到成功页面
    }
}
