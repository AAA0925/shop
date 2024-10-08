package com.example.shopping.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.shopping.dao.ProductDAO;
import com.example.shopping.model.Product;
@WebServlet("/history")
public class HistoryController extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> historicalProducts = productDAO.getHistoricalProducts(); // 获取已售商品
        request.setAttribute("historicalProducts", historicalProducts);
        request.getRequestDispatcher("history.jsp").forward(request, response);
    }
}

