package org.example.ecommerce.repo;


import org.example.ecommerce.model.Orders;
import org.example.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {





    @Query("SELECT DISTINCT o FROM Orders o " +
            "JOIN FETCH o.user u " +
            "LEFT JOIN FETCH o.orderItems oi " +
            "LEFT JOIN FETCH oi.product")
    List<Orders> findAllOrdersWithUsers();

    List<Orders> findByUser(User user);
}
