package com.example.egen.payment.controller;


import java.security.Provider.Service;
import java.util.*;


import com.example.egen.payment.entity.OrderPaymentConfirmation;
import com.example.egen.payment.entity.OrderPaymentEntity;
import com.example.egen.payment.entity.Payment;
import com.example.egen.payment.entity.PaymentMethod;
import com.example.egen.payment.entity.PaymentOrderResponse;
import com.example.egen.payment.entity.PaymentPriceUpdate;
import com.example.egen.payment.service.OrderPaymentConfirmationService;
import com.example.egen.payment.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private OrderPaymentConfirmationService orderPaymentConfirmationservice;

    @Autowired
    private PaymentService paymentService;

   
    @PostMapping(value="/saveOrderPayment")
    public OrderPaymentConfirmation savePayment(@RequestBody OrderPaymentEntity data){
      
    OrderPaymentConfirmation orderPaymentConfirmation = new OrderPaymentConfirmation();
    orderPaymentConfirmation = orderPaymentConfirmationservice.findPaymentConfirmationByOrderId(data.getOrder_id());
    
    System.out.println("Payment info"+data);
    System.out.println("Order Id"+data.getOrder_id());
    
        
        if(data.getPaymentInfo().size()==1){
            PaymentMethod paymentInfo= data.getPaymentInfo().get(0);   
    
            Payment payment= new Payment(
                data.getOrder_id(),
                paymentInfo.getPayment_method(),
                paymentInfo.getPayment_date(),
                paymentInfo.getCard_number(),
                paymentInfo.getSecurity_Code(),
                paymentInfo.getPrice());
         
            payment= paymentService.savePayment(payment);
            
                orderPaymentConfirmation= new OrderPaymentConfirmation(
                payment.getOrderId(),
             //   payment.getPayment_id(),
                payment.getPrice(),
                RandomString(5)
             
            );
            orderPaymentConfirmation= orderPaymentConfirmationservice.savePaymentConfirmation(orderPaymentConfirmation);
         }
    
         if(data.getPaymentInfo().size()==2){
            Payment payment = new Payment();
             for(PaymentMethod temp: data.getPaymentInfo() ){
                  payment= new Payment(data.getOrder_id(),
                                    temp.getPayment_method(),
                                    temp.getPayment_date(),
                                    temp.getCard_number(),
                                    temp.getSecurity_Code(),
                                    temp.getPrice());
    
            payment= paymentService.savePayment(payment);
    
                       }
            orderPaymentConfirmation= new OrderPaymentConfirmation(
                                    payment.getOrderId(),
                                    // payment.getPayment_id(),
                                    payment.getPrice()*2,
                                    RandomString(5)
                
                );
            orderPaymentConfirmation= orderPaymentConfirmationservice.savePaymentConfirmation(orderPaymentConfirmation);  
          
    
                   }
            return orderPaymentConfirmation;
    }

    @PutMapping(value="/updateOrderPaymentPrice")
    public String updateOrderPaymentPrice(@RequestBody PaymentPriceUpdate data){
        List<Integer> paymentIds= new ArrayList<>();
        paymentIds= data.getPaymentId();
        OrderPaymentConfirmation orderPaymentConfirmation= new OrderPaymentConfirmation();
        
        if(paymentIds.size()==1){
           
            Payment payment= paymentService.getPaymentById(data.getPaymentId().get(0));
            payment.setPrice(data.getTotalPrice());  
            payment= paymentService.updatePayment(payment);

            orderPaymentConfirmation= orderPaymentConfirmationservice
                                     .findPaymentConfirmationByOrderId(data.getOrderId());

            orderPaymentConfirmation.setTotal_price(data.getTotalPrice());

            orderPaymentConfirmation= orderPaymentConfirmationservice
                                      .updatePaymentConfirmation(orderPaymentConfirmation);  
             return "Payment of price:"+orderPaymentConfirmation.getTotal_price()+ " "+"Confimation Id: "+ orderPaymentConfirmation.getConfirmation_number();
    
        }
        if(paymentIds.size()==2){
   
        for(Integer temp1: paymentIds){
            Payment payment= paymentService.getPaymentById(temp1);
                    payment.setPrice(data.getTotalPrice()/2);
                    
                    payment= paymentService.updatePayment(payment);
            }
            orderPaymentConfirmation= orderPaymentConfirmationservice
                                    .findPaymentConfirmationByOrderId(data.getOrderId());
    
                                    orderPaymentConfirmation.setTotal_price(data.getTotalPrice());
                
                                    orderPaymentConfirmation= orderPaymentConfirmationservice
                                    .updatePaymentConfirmation(orderPaymentConfirmation);  

                                    return "Payment of price:"+orderPaymentConfirmation.getTotal_price()+ " "+"Confimation Id: "+ orderPaymentConfirmation.getConfirmation_number();
    
        }
     
        return " Payment Failed";
    }
        
    public String RandomString(int n){
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    }
    @GetMapping("/PaymentByOrderId/{id}")
    public PaymentOrderResponse getPaymentById(@PathVariable("id")  Integer orderId){
       
        List<Integer> paymentIds= new ArrayList<>();
        List<Payment> paymentList= new ArrayList<>();
        OrderPaymentConfirmation orderPaymentConfirmation =orderPaymentConfirmationservice.findPaymentConfirmationByOrderId(orderId);
        
        paymentList= paymentService.getPaymentByOrderId(orderId);
        for(Payment temp:paymentList){
            paymentIds.add(temp.getPayment_id());
        }

        paymentList= paymentService.getPaymentByIds(paymentIds);
        
        PaymentOrderResponse paymentOrderResponse = new PaymentOrderResponse(
        orderPaymentConfirmation.getTotal_price(),
        orderPaymentConfirmation.getConfirmation_number(),
        paymentList
        );
    

        //return service.getPaymentById(orderId);
        return  paymentOrderResponse;
    }
    // @PostMapping("/addPayments")
    //    public List<Payment> addProduct(@RequestBody List<Payment> payments){
    //        return service.savePayments(payments);
    //    } 

    // @GetMapping("/payments")
    // public List <Payment> getPayments(){
    //     return service.getPayments();
    // }

    // @GetMapping("/PaymentById/{id}")
    // public Payment getPaymentById(@PathVariable int id){
    //     return service.getPaymentById(id);
    // }
    
    // @PutMapping("/updateItem")
    // public Payment updateProduct(@RequestBody Payment payment){
    //     return service.updatePayment(payment);
    // }
    
    // @DeleteMapping("/deletePayment/{id}")
    // public String deletePayment(@PathVariable int id){
    //     return service.deletePaymentById(id);
    // }
   
}
