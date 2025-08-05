package org.example.eccomerce.model;


import jakarta.persistence.*;


@Entity
public class OrderItems {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;



    @ManyToOne
    private  Orders orders;

    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    private Product product;
}
