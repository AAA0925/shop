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

        productDAO.freezeProduct(productId); // 冻结商品

        // 在这里处理买家意向逻辑（如记录信息）
        
        response.sendRedirect("success.jsp");
    }
}
