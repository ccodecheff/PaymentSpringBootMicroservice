package com.example.egen.payment.entity;

public class PaymentMethod {
    private String payment_method;
    private String payment_date;
    private String card_number;
    private String security_Code;
    private Double price;
    
    public PaymentMethod(){}

    

    public PaymentMethod(String payment_method, String payment_date, String card_number, String security_Code,
            Double price) {
        this.payment_method = payment_method;
        this.payment_date = payment_date;
        this.card_number = card_number;
        this.security_Code = security_Code;
        this.price = price;
    }



    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getSecurity_Code() {
        return security_Code;
    }

    public void setSecurity_Code(String security_Code) {
        this.security_Code = security_Code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
}