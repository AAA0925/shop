package com.example.shopping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.shopping.dao.BuyerIntentDAO;
import com.example.shopping.dao.ProductDAO;
import com.example.shopping.dao.SellerDAO;
@WebServlet("/reset-system")
public class ResetSystemController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SellerDAO sellerDAO = new SellerDAO();
        ProductDAO productDAO = new ProductDAO();
        BuyerIntentDAO buyerIntentDAO = new BuyerIntentDAO();

        // 重置卖家密码
        sellerDAO.resetToDefault();
        // 清空所有商品和购买意向
        productDAO.clearAllProducts();
        buyerIntentDAO.clearAllBuyerIntents();

        response.sendRedirect("login.jsp");
    }
}
