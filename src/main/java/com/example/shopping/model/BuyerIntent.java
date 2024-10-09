package com.example.shopping.model;

public class BuyerIntent {
    private long id;
    private long productId;
    private String userName;
    private String userContact;

    public BuyerIntent(long id, long productId, String userName, String userContact) {
        this.id = id;
        this.productId = productId;
        this.userName = userName;
        this.userContact = userContact;
    }

    // Getters 和 Setters
    public long getId() { return id; }
    public long getProductId() { return productId; }
    public String getUserName() { return userName; }
    public String getUserContact() { return userContact; }
}
