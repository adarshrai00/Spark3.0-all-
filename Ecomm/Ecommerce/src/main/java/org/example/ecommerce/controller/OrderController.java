package org.example.ecommerce.controller;


import org.example.ecommerce.dto.OrderDTO;
import org.example.ecommerce.dto.OrderRequest;
import org.example.ecommerce.model.Orders;
import org.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/place/{userId}")
    public OrderDTO placeOrder(@PathVariable Long userId,  @RequestBody OrderRequest orderRequest) {

         return orderService.placeOrder(Math.toIntExact(userId),orderRequest.getProductQuantities(),orderRequest.getTotalAmount());
    }

    @GetMapping("/all-orders")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/user/{userId}")
    public List<OrderDTO> getOrdersByUser(@PathVariable Long userId) {
          return orderService.getOrdersByUser(userId);
    }
}
