package com.example.egen.payment.entity;

public class OrderPayment {
      
   
    private Integer order_id;
    private PaymentMethod paymentInfo;
   
    
    public OrderPayment(){}

    public OrderPayment(Integer order_id, PaymentMethod payments) {
        this.order_id = order_id;
        this.paymentInfo= payments;
    }
    public Integer getOrder_id() {
        return order_id;
    }
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
    public PaymentMethod getPayments() {
        return paymentInfo;
    }
    public void setPayments(PaymentMethod payments) {
        this.paymentInfo = payments;
    }

    
}
