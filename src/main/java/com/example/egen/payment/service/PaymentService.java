package com.example.egen.payment.service;

import java.util.List;

import com.example.egen.payment.entity.Payment;
//import com.example.egen.payment.entity.PaymentEntitiy;
import com.example.egen.payment.repository.PaymentImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentImpl repository;

    public Payment savePayment(Payment item){
        return repository.save(item);
    }

    public List<Payment> savePayments(List<Payment> items)
    {
        return  repository.saveAll(items);
    } 

    public List <Payment> getPayments()
    {
        return  repository.findAll();
    } 

    public Payment getPaymentById(int id)
    {
        return  repository.findById(id).orElse(null);
        
    }
    public List <Payment> getPaymentByIds(Iterable<Integer> iterator)
    {
        return  repository.findAllById(iterator);
        
    } 

    public List<Payment> getPaymentByOrderId(Integer id)
    {
        return  repository.findByOrderId(id);
        
    }

    public String deletePaymentById(int id)
    {
        repository.deleteById(id);
        return " payment Removed !!"+id;
    }

    public Payment updatePayment(Payment payment)
    {
        Payment existingProduct= repository.findById(payment.getPayment_id()).orElse(null);
        existingProduct.setPayment_method(payment.getPayment_method());
        existingProduct.setPayment_date(payment.getPayment_date());
        existingProduct.setCard_number(payment.getCard_number());
        existingProduct.setSecurity_Code(payment.getSecurity_Code());
        return repository.save(existingProduct);
    }


}
