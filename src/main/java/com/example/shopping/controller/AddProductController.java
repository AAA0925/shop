package com.example.shopping.controller;

import com.example.shopping.dao.ProductDAO;
import com.example.shopping.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-product")
public class AddProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取表单中的数据
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        String priceStr = request.getParameter("price");
        
        // 将价格从字符串转换为数字
        double price = Double.parseDouble(priceStr);
        
        // 创建新的商品对象
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);
        product.setStatus("available"); // 默认设置为可用状态

        // 使用DAO将商品保存到数据库
        ProductDAO productDAO = new ProductDAO();
         productDAO.addProduct(product);
        
        // 根据操作结果重定向到相应页面
        
            response.sendRedirect("admin.jsp?success=true");

        
    }
}

