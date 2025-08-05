package org.example.ecommerce.dto;

public class OrderItemDTO {
    private String productName;
    private int quantity;
    private double productPrice;

    public OrderItemDTO(String productName, double quantity, double productPrice) {
        this.productName = productName;
        this.quantity = (int) quantity;
        this.productPrice = productPrice;
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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
