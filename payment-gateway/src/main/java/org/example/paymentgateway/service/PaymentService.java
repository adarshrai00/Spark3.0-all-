package org.example.paymentgateway.service;


import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.example.paymentgateway.entity.PaymentOrder;
import org.example.paymentgateway.repo.PaymentRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {
    @Value("${razorpay.key_id}")
    private String keyId;
    @Value ("${razorpay.key_secret}")
    private String keySecret;
    @Autowired
    PaymentRepo paymentRepo;
    @Autowired
    EmailService emailService;
    public String createOrder(PaymentOrder paymentOrder) throws RazorpayException {

        RazorpayClient client=new RazorpayClient(keyId,keySecret);
        JSONObject orderRequest=new JSONObject();
        orderRequest.put("amount",(int)(paymentOrder.getAmount()*100));
        orderRequest.put("currency","INR");
        orderRequest.put("receipt","txn"+ UUID.randomUUID());

        Order razorpayOrder=client.orders.create(orderRequest);
        paymentOrder.setOrderId(razorpayOrder.get("id"));
        paymentOrder.setStatus("Created");
        paymentOrder.setCreatedAt(LocalDateTime.now());
        paymentRepo.save(paymentOrder);
        return  razorpayOrder.toString();
    }

    public void updateOrderStatus(String paymentId, String orderId, String status) throws RazorpayException {
        PaymentOrder order = paymentRepo.findByOrderId(orderId);

        if (order == null) {
            throw new RuntimeException("No order found for orderId: " + orderId);
        }

        // It's okay if paymentId is null; only set if it's not blank
        if (paymentId != null && !paymentId.isBlank()) {
            order.setPaymentId(paymentId);
        }

        order.setStatus(status);
        paymentRepo.save(order);

        // Send email only if payment is successful
        if ("SUCCESS".equalsIgnoreCase(status)) {
            System.out.println("Email sent");
            emailService.sendEmail(
                    order.getEmail(),
                    order.getName(),
                    order.getCourseName(),
                    order.getAmount()

            );

        }
    }

}
