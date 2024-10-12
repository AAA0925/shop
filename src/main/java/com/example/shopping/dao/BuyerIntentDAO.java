package com.example.shopping.dao;

import com.example.shopping.model.BuyerIntent;
import com.example.shopping.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyerIntentDAO {

    // 获取所有买家的购买意向信息
    public List<BuyerIntent> getAllBuyerIntents() {
        List<BuyerIntent> buyerIntents = new ArrayList<>();
        String sql = "SELECT * FROM BuyerIntent"; // 假设表名为 BuyerIntents

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                BuyerIntent intent = new BuyerIntent(
                        rs.getInt("id"),            // 假设有自增 ID 字段
                        rs.getInt("productId"),     // 对应的商品ID
                        rs.getString("userName"),   // 买家姓名
                        rs.getString("userContact") // 买家联系方式
                );
                buyerIntents.add(intent);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return buyerIntents;
    }
    public List<BuyerIntent> getBuyerIntentsExcludingSoldProducts() {
        List<BuyerIntent> intents = new ArrayList<>();
        String sql = "SELECT b.id, b.productId, b.userName, b.userContact " +
                     "FROM BuyerIntent b " +
                     "JOIN Products p ON b.productId = p.id " +
                     "WHERE p.status != 'sold'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                intents.add(new BuyerIntent(
                    rs.getInt("id"),
                    rs.getInt("productId"),
                    rs.getString("userName"),
                    rs.getString("userContact")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return intents;
    }


    // 可以添加其他方法，如添加购买意向
    public void addBuyerIntent(BuyerIntent intent) {
        String sql = "INSERT INTO BuyerIntent (productId, userName, userContact) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, intent.getProductId());
            pstmt.setString(2, intent.getUserName());
            pstmt.setString(3, intent.getUserContact());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void clearAllBuyerIntents() {
        String sql = "DELETE FROM BuyerIntents";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
