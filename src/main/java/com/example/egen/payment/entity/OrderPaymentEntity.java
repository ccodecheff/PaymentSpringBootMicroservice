package com.example.egen.payment.entity;

import java.util.List;

public class OrderPaymentEntity {
    private Integer order_id;
    private List <PaymentMethod> paymentInfo;

 public OrderPaymentEntity(){}

public OrderPaymentEntity(Integer order_id, List<PaymentMethod> paymentInfo) {
    this.order_id = order_id;
    this.paymentInfo = paymentInfo;
}

public Integer getOrder_id() {
    return order_id;
}

public void setOrder_id(Integer order_id) {
    this.order_id = order_id;
}

public List<PaymentMethod> getPaymentInfo() {
    return paymentInfo;
}

public void setPaymentInfo(List<PaymentMethod> paymentInfo) {
    this.paymentInfo = paymentInfo;
}
 
 
}
