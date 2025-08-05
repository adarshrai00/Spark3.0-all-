package org.example.eccomerce.dto;

public class OrderItemDTO {
    private String productName;
    private int quantity;
    private int  ProductPrice;


    public OrderItemDTO(String productName, int quantity, int prodectPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.ProductPrice = prodectPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProdectPrice() {
        return ProductPrice;
    }

    public void setProdectPrice(int prodectPrice) {
        this.ProductPrice = prodectPrice;
    }
}
