package com.example.shopping.controller;

import com.example.shopping.dao.ProductDAO;
import com.example.shopping.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/add-product")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // 1MB
    maxFileSize = 1024 * 1024 * 5,   // 5MB
    maxRequestSize = 1024 * 1024 * 10 // 10MB
)
public class AddProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取表单数据
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        // 获取图片文件
        Part filePart = request.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        
        // 设置保存路径
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir(); // 创建上传目录
        }

        // 保存文件到服务器
        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath);

        // 图片的相对路径（用于数据库存储）
        String imageUrl = "uploads/" + fileName;

        // 创建并设置商品对象
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImage(imageUrl); // 设置图片路径
        product.setStatus("available"); // 设置商品状态为可用

        // 保存商品到数据库
        ProductDAO productDAO = new ProductDAO();
        productDAO.addProduct(product);

        // 重定向到后台页面
        response.sendRedirect("admin.jsp?success=true");
    }
}
