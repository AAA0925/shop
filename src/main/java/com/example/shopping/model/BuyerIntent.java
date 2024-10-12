package com.example.shopping.model;

public class BuyerIntent {
    private int id;
    private int productId;
    private String userName;
    private String userContact;

    public BuyerIntent(int id, int productId, String userName, String userContact) {
        this.id = id;
        this.productId = productId;
        this.userName = userName;
        this.userContact = userContact;
    }
    public BuyerIntent() {
    	
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }
}
