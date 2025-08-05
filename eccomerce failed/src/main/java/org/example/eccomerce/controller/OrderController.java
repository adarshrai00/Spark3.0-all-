package org.example.eccomerce.controller;


import org.example.eccomerce.dto.OrderDTO;
import org.example.eccomerce.model.OrderRequest;
import org.example.eccomerce.model.Orders;
import org.example.eccomerce.model.User;
import org.example.eccomerce.repo.OrderRepository;
import org.example.eccomerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")

public class OrderController {
   @Autowired
   private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/place/{userId)")
     public OrderDTO placeOrder(@PathVariable long userId, @RequestBody OrderRequest orderRequest)
     {
        return orderService.placeOrder(userId,orderRequest.getProductQuantities(),orderRequest.getTotalAmount());
     }
    @RequestMapping("/all-orders")
     public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
     }
     @RequestMapping("/user/{userId}")
     public List<OrderDTO> getOrdersByUserId(@PathVariable long userId) {
       return  orderService.getOrdersByUser(userId);

     }


}
