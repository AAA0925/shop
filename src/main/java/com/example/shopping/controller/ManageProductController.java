package com.example.shopping.controller;


import com.example.shopping.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manage-product")
public class ManageProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String productIdStr = request.getParameter("productId");
        String action = request.getParameter("action");

        if (productIdStr != null && action != null) {
            long productId = Long.parseLong(productIdStr);
            ProductDAO productDAO = new ProductDAO();
            
            switch (action) {
                case "freeze":
                    productDAO.freezeProduct(productId);
                    break;
                case "unlist":
                    productDAO.sellProduct(productId); // 你可以改为一个专门的下架方法
                    break;
                case "restore":
                    productDAO.updateProductStatus(productId, "available");
                    break;
            }
            
            response.sendRedirect("admin.jsp?success=true");
        }
    }
}
