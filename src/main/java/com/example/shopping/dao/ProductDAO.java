package com.example.shopping.dao;

import com.example.shopping.model.Product;
import com.example.shopping.model.BuyerIntent;
import com.example.shopping.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	public List<Product> getAllProducts() {
	    List<Product> products = new ArrayList<>();
	    String sql = "SELECT * FROM Products";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {
	        while (rs.next()) {
	            products.add(new Product(rs.getLong("id"), rs.getString("name"), rs.getString("description"),
	                    rs.getString("image"), rs.getDouble("price"), rs.getString("status")));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return products;
	}

    public List<Product> getAvailableProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE status IN ('available', 'frozen')";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                products.add(new Product(rs.getLong("id"), rs.getString("name"), rs.getString("description"),
                        rs.getString("image"), rs.getDouble("price"), rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void freezeProduct(long productId) {
        updateProductStatus(productId, "frozen");
    }

    public void sellProduct(long productId) {
        updateProductStatus(productId, "sold");
    }

    public void updateProductStatus(long productId, String newStatus) {
        String sql = "UPDATE Products SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newStatus);
            pstmt.setLong(2, productId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product) {
        String sql = "INSERT INTO Products (name, description, image, price, status) VALUES (?, ?, ?, ?, 'available')";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setString(3, product.getImage());
            pstmt.setDouble(4, product.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getHistoricalProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE status = 'sold'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                products.add(new Product(rs.getLong("id"), rs.getString("name"), rs.getString("description"),
                        rs.getString("image"), rs.getDouble("price"), rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void recordBuyerIntent(long productId, String userName, String userContact) {
        String sql = "INSERT INTO BuyerIntent (productId, userName, userContact) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, productId);
            pstmt.setString(2, userName);
            pstmt.setString(3, userContact);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<BuyerIntent> getBuyerIntents() {
        List<BuyerIntent> intents = new ArrayList<>();
        String sql = "SELECT * FROM BuyerIntent";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                intents.add(new BuyerIntent(rs.getLong("id"), rs.getLong("productId"),
                        rs.getString("userName"), rs.getString("userContact")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return intents;
    }
}
