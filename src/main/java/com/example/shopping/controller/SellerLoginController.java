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
	    request.setCharacterEncoding("utf-8");
	    String action = request.getParameter("action"); // 获取操作类型

	    SellerDAO sellerDAO = new SellerDAO();
	    if ("login".equals(action)) {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
	            if (sellerDAO.validateSeller(username, password)) {
	                request.getSession().setAttribute("seller", username);
	                response.sendRedirect("admin.jsp");
	            } else {
	                response.sendRedirect("login.jsp?error=true");
	            }
	        } else {
	            response.sendRedirect("login.jsp?error=emptyfields");
	        }
	    } else if ("reset".equals(action)) {
	        sellerDAO.resetToDefault();
	        response.sendRedirect("login.jsp?resetSuccess=true");
	    } else {
	        response.sendRedirect("login.jsp?error=true");
	    }
	}
}