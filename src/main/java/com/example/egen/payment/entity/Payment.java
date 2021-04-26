package com.example.egen.payment.entity;
//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_TBL")

public class Payment {
   
    @Id 
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer payment_id; 

    private Integer orderId;
    private String payment_method;
    private String payment_date;
    private String card_number;
    private String security_Code;
    private Double price;
    
    
   

    public Payment() { }
    
    
    
    public Payment(Integer orderId, String payment_method, String payment_date, String card_number,
            String security_Code, Double price) {
        this.orderId = orderId;
        this.payment_method = payment_method;
        this.payment_date = payment_date;
        this.card_number = card_number;
        this.security_Code = security_Code;
        this.price = price;
    }



    public Integer getOrderId() {
        return orderId;
    }



    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }



    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Integer payment_id) {
        this.payment_id = payment_id;
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
   
     
     
     
     
}
