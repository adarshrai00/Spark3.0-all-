package org.example.ecommerce.service;

import org.example.ecommerce.dto.OrderDTO;
import org.example.ecommerce.dto.OrderItemDTO;
import org.example.ecommerce.model.OrderItem;
import org.example.ecommerce.model.Orders;
import org.example.ecommerce.model.Product;
import org.example.ecommerce.model.User;
import org.example.ecommerce.repo.OrderRepository;
import org.example.ecommerce.repo.ProductRepository;
import org.example.ecommerce.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {
      @Autowired
      private OrderRepository orderRepository;
       @Autowired
       private ProductRepository productRepository;
       @Autowired
       private UserRepository userRepository;
    public OrderDTO placeOrder(int userId, Map<Long, Integer> productQuantities, double totalAmount) {

        User user=  userRepository.findById(userId)
                  .orElseThrow(() -> new RuntimeException("User not found"));
                   Orders order = new Orders();
                   order.setUser(user);
                   order.setTotalAmount(totalAmount);
                   order.setStatus("pending");
                   order.setOrderDate(new Date());

        List<OrderItem> orderItems =  new ArrayList<>();
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();

        for(Map.Entry<Long, Integer> entry : productQuantities.entrySet()) {

         Product product= productRepository.findById(Math.toIntExact(entry.getKey()))
                 .orElseThrow(() -> new RuntimeException("Product not found"));


OrderItem orderItem = new OrderItem();
orderItem.setOrder(order);
orderItem.setProduct(product);
orderItem.setQuantity(entry.getValue());
orderItems.add(orderItem);
orderItemDTOS.add(new OrderItemDTO(product.getName(),product.getPrice(),entry.getValue()));
         }
      order.setOrderItems(orderItems);
        Orders saveOrder= orderRepository.save(order);

        return new OrderDTO(saveOrder.getId(),saveOrder.getTotalAmount(),
                saveOrder.getStatus(),saveOrder.getOrderDate(),orderItemDTOS);
          }

       public List<OrderDTO> getAllOrders() {
         List<Orders> orders = orderRepository.findAllOrdersWithUsers();
         return orders.stream().map(this::converToDTO).collect(Collectors.toList());
       }

    private OrderDTO converToDTO(Orders orders) {
        List<OrderItemDTO> OrderItems= orders.getOrderItems().stream()
                .map(item->new OrderItemDTO(
               item.getProduct().getName(),
                        item.getProduct().getPrice(),
                        item.getQuantity())).collect(Collectors.toList());

        return new OrderDTO(
                orders.getId(),
                orders.getTotalAmount(),
                orders.getStatus(),
                orders.getUser() != null ? orders.getUser().getEmail() : "not found",
                OrderItems
        );
    }

    public List<OrderDTO> getOrdersByUser(Long userId) {
       Optional<User> userOp= userRepository.findById(Math.toIntExact(userId));

       if(userOp.isEmpty()) {
           throw new RuntimeException("User not found");
       }

       User user = userOp.get();
       List<Orders> byUser= orderRepository.findByUser(user);
       return byUser.stream().map(this::converToDTO).collect(Collectors.toList());
    }
}
