package org.example.ecommerce.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {

    private int id;
    private double totalAmount;
    private String status;
    private Date orderDate;
    private String userName;
    private String email;
    private List<OrderItemDTO> orderItems;

    public OrderDTO(int id, double totalAmount, String status, Date orderDate, String userName, String email, List<OrderItemDTO> orderItems) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderDate = orderDate;
        this.userName = userName;
        this.email = email;
        this.orderItems = orderItems;
    }

    public OrderDTO(int id, double totalAmount, String status, Date orderDate,  List<OrderItemDTO> orderItems) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderDate = orderDate;

        this.orderItems = orderItems;
    }

    public OrderDTO(int id, String status, double totalAmount, Object o) {
    }

    public OrderDTO(int id, String status, double totalAmount, String s, Object o, List<OrderItemDTO> orderItems) {
    }

    public OrderDTO(int id, double totalAmount, String status, String s, List<OrderItemDTO> orderItems) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
