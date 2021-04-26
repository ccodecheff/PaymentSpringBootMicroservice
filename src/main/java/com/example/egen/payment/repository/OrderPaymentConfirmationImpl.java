package com.example.egen.payment.repository;

import java.util.List;

import com.example.egen.payment.entity.OrderPaymentConfirmation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderPaymentConfirmationImpl extends JpaRepository <OrderPaymentConfirmation,Integer> {
    OrderPaymentConfirmation findByOrderId(Integer orderId);
}
