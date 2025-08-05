package org.example.eccomerce.repo;

import org.example.eccomerce.model.Orders;
import org.example.eccomerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query("SELECT o FROM Orders o JOIN FETCH o.user")
    List<Orders> findAllOrdersWithUsers();

      List<Orders> findByUser(User user);
}
