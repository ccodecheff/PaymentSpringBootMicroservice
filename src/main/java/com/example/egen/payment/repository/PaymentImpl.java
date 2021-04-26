package com.example.egen.payment.repository;


import java.util.List;

import com.example.egen.payment.entity.Payment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentImpl extends JpaRepository <Payment,Integer>{
    List<Payment> findByOrderId(Integer orderId);
}
