package org.example.eccomerce.service;

import org.example.eccomerce.dto.OrderDTO;
import org.example.eccomerce.dto.OrderItemDTO;
import org.example.eccomerce.model.OrderItems;
import org.example.eccomerce.model.Orders;
import org.example.eccomerce.model.Product;
import org.example.eccomerce.model.User;
import org.example.eccomerce.repo.OrderRepository;
import org.example.eccomerce.repo.ProductRepository;
import org.example.eccomerce.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public OrderDTO placeOrder(long usesrId, Map<Long,Integer> productQuantities, double totalAmount) {
       User user=   userRepository.findById(usesrId).orElseThrow(()->new RuntimeException("User not found"));
       Orders orders = new Orders();
       orders.setUser(user);
       orders.setTotalAmount(totalAmount);
       orders.setDate(new Date());
       orders.setStatus("Pending");

        List<OrderItems> orderItems= new ArrayList<>();
        List<OrderItemDTO> orderItemDTOs = new ArrayList<>();
        for(Map.Entry<Long,Integer> entry : productQuantities.entrySet()) {

           Product product=  productRepository.findById(entry.getKey()).orElseThrow(()->new RuntimeException("Product not found"));
           OrderItems orderItem = new OrderItems();
           orderItem.setProduct(product);
           orderItem.setOrders(orders);
           orderItem.setQuantity(entry.getValue());
           orderItems.add(orderItem);
            orderItemDTOs.add(new OrderItemDTO(product.getName(), (int) product.getPrice(),entry.getValue()));
            orders.setOrderItems(orderItems);
           Orders saveOrder=   orderRepository.save(orders);
           return new OrderDTO(saveOrder.getId(),saveOrder.getTotalAmount(),saveOrder.getStatus(),
                   saveOrder.getDate(), orderItemDTOs);


        }
    }

    public List<OrderDTO> getAllOrders() {
       List<Orders> orders  =  orderRepository.findAllOrdersWithUsers();
       return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private OrderDTO convertToDTO(Orders orders) {

        List<OrderItemDTO> orderitems = orders.getOrderItems().stream().map(item -> new OrderItemDTO(
                item.getProduct().getName(),
                (int) item.getProduct().getPrice(),
                item.getQuantity()

        )).collect(Collectors.toList());
        return new OrderDTO(
                orders.getId(),
                orders.getTotalAmount(),
                orders.getStatus(),
                orders.getDate(),
                orders.getUser(),
                orderitems

        );
    }
        public List<OrderDTO> getOrdersByUser(long userId) {

            Optional<User> userOp = userRepository.findById(userId);
            if(userOp.isEmpty()) {
                throw new RuntimeException("User not found");
            }
            User user =userOp.get();
            List<Orders> orderList=orderRepository.findByUser(user);
            return orderList.stream().map(this::convertToDTO).collect(Collectors.toList());

        }

}
