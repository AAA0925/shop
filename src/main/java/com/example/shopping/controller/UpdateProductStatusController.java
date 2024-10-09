package com.example.shopping.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.shopping.dao.ProductDAO;

import java.io.IOException;

@WebServlet("/admin/update-product-status")
public class UpdateProductStatusController extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long productId = Long.parseLong(request.getParameter("productId"));
        String newStatus = request.getParameter("status");

        productDAO.updateProductStatus(productId, newStatus); // 更新商品状态

        response.sendRedirect("admin.jsp"); // 重定向回商家后台
    }
}

