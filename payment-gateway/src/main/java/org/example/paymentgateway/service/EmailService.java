package org.example.paymentgateway.service;


import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public  void sendEmail(String toEmail,String name,String course,double amount) throws RazorpayException

    {
       SimpleMailMessage message = new SimpleMailMessage();
       message.setTo(toEmail);
       message.setSubject("payment success of "+ course);
       message.setText("hey"+name+" thankyou for purchasing "+course);
       mailSender.send(message);

    }
}
