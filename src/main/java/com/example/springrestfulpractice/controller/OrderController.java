package com.example.springrestfulpractice.controller;

import com.example.springrestfulpractice.model.Order;
import com.example.springrestfulpractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders(){
        List<Order> orderData = this.orderService.getAllOrders();
        if(orderData.size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "無訂單資料");
        }
        return orderData;
    }

    @GetMapping("/{seq}")
    public Order getOrderById(@PathVariable int seq){
        Order orderData = this.orderService.getOrderById(seq);
        if(orderData == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "查無此訂單資料");
        }
        return orderData;
    }

    @PostMapping()
    public Order createOrder(@RequestBody Order newOrder){
        Order orderData = this.orderService.createOrder(newOrder);
        return orderData;
    }

    @PutMapping("/{seq}")
    public Order updateOrder(@PathVariable  int seq, @RequestBody Order updateOrder){
        Order orderData = this.orderService.updateOrder(seq, updateOrder);
        if(orderData == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "查無此訂單資料");
        }
        return orderData;
    }

    @DeleteMapping("/{seq}")
    public Order deleteOrder(@PathVariable  int seq){
        Order orderData = this.orderService.deleteOrder(seq);
        if(orderData == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "查無此訂單資料");
        }
        return orderData;
    }

}
