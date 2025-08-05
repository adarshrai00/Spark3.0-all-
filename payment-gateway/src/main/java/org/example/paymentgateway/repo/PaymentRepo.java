package org.example.paymentgateway.repo;

import com.razorpay.Payment;
import org.example.paymentgateway.entity.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaymentRepo extends JpaRepository<PaymentOrder, Long> {
    PaymentOrder findByOrderId( String orderId);
}
