package com.example.egen.payment.entity;

import javax.persistence.*;



@Entity
@Table(name="payment_confirmation_TBL")
public class OrderPaymentConfirmation {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique=true)
    private Integer orderId;
    
    
    private  Double  total_price;
    private String Confirmation_number;
    
    public OrderPaymentConfirmation(){}

   
    public OrderPaymentConfirmation(Integer orderId, Double total_price,
            String confirmation_number) {
        this.orderId = orderId;
      
        this.total_price = total_price;
        Confirmation_number = confirmation_number;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getOrderId() {
        return orderId;
    }


    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public String getConfirmation_number() {
        return Confirmation_number;
    }

    public void setConfirmation_number(String confirmation_number) {
        Confirmation_number = confirmation_number;
    }

    
    
}
