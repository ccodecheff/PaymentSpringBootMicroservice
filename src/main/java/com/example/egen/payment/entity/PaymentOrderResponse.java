package com.example.egen.payment.entity;

import java.util.List;

public class PaymentOrderResponse {
    
    private  Double  totalPrice;
    private String confirmationNumber;
    private List<Payment> paymentInfo;

    public PaymentOrderResponse(){}

    public PaymentOrderResponse(Double totalPrice, String confirmationNumber, List<Payment> paymentInfo) {
        this.totalPrice = totalPrice;
        this.confirmationNumber = confirmationNumber;
        this.paymentInfo = paymentInfo;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public List<Payment> getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(List<Payment> paymentInfo) {
        this.paymentInfo = paymentInfo;
    }


}
