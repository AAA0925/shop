package com.example.shopping.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.shopping.dao.BuyerIntentDAO;
import com.example.shopping.model.BuyerIntent;

@WebServlet("/buyer-intent")
public class BuyerIntentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String productIdStr = request.getParameter("productId");
        String userName = request.getParameter("userName");
        String userContact = request.getParameter("userContact");

        if (productIdStr != null) {
            int productId = Integer.parseInt(productIdStr);
            BuyerIntent buyerIntent = new BuyerIntent();
            buyerIntent.setProductId(productId);
            buyerIntent.setUserName(userName);
            buyerIntent.setUserContact(userContact);

            BuyerIntentDAO buyerIntentDAO = new BuyerIntentDAO();
            buyerIntentDAO.addBuyerIntent(buyerIntent);

            response.sendRedirect("index.jsp?success=true");
        }
    }
}

