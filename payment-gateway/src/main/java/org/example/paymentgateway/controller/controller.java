package org.example.paymentgateway.controller;


import com.razorpay.RazorpayException;
import org.example.paymentgateway.entity.PaymentOrder;
import org.example.paymentgateway.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class controller {
    @Autowired
    private PaymentService paymentService;


    @PostMapping("/create-order")
    public ResponseEntity<String> createOrder(@RequestBody PaymentOrder paymentOrder) throws RazorpayException {


        String  ServiceOrder = paymentService.createOrder(paymentOrder);
        return ResponseEntity.ok(ServiceOrder);
    }


    @PostMapping("/update-order")
    public  ResponseEntity<String> updateOrderStatus(@RequestParam String paymentId ,
    @RequestParam String orderId,@RequestParam String status) throws RazorpayException {
        paymentService.updateOrderStatus(paymentId,orderId,status);
        return  ResponseEntity.ok("success");

    }
}
