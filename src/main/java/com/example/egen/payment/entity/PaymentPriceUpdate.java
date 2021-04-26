package com.example.egen.payment.entity;

import java.util.List;

public class PaymentPriceUpdate {
    private Integer orderId;
    private Double totalPrice;
    private  List<Integer> paymentId;

    public PaymentPriceUpdate(){

    }

    public PaymentPriceUpdate(Integer orderId, Double totalPrice, List<Integer> paymentId) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.paymentId = paymentId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Integer> getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(List<Integer> paymentId) {
        this.paymentId = paymentId;
    }

    
}
