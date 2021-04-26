package com.example.egen.payment.service;

import java.util.List;

import com.example.egen.payment.entity.OrderPaymentConfirmation;
import com.example.egen.payment.repository.OrderPaymentConfirmationImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPaymentConfirmationService {

    @Autowired
    private OrderPaymentConfirmationImpl repository;

    public OrderPaymentConfirmation savePaymentConfirmation(OrderPaymentConfirmation item){
        return repository.save(item);
    }

    public List <OrderPaymentConfirmation> savePaymentsConfirmation(List <OrderPaymentConfirmation> items)
    {
        return  repository.saveAll(items);
    } 

    public OrderPaymentConfirmation findPaymentConfirmationById(int id)
    {
        return  repository.findById(id).orElse(null);
        
    }

    public OrderPaymentConfirmation findPaymentConfirmationByOrderId(Integer id){
        return  repository.findByOrderId(id);
    }

    public OrderPaymentConfirmation updatePaymentConfirmation(OrderPaymentConfirmation payment)
    {
        OrderPaymentConfirmation existingPaymentConfirmation= repository.findById(payment.getId()).orElse(null);
       
        existingPaymentConfirmation.setConfirmation_number(payment.getConfirmation_number());
        existingPaymentConfirmation.setOrderId(payment.getOrderId());
        existingPaymentConfirmation.setTotal_price(payment.getTotal_price());
      
        
        return repository.save(existingPaymentConfirmation);
    }
    

}
