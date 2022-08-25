package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.model.Meal;
import com.example.springrestfulpractice.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    List<Order> orderList;
    List<Meal> mealList;

    // 資料預先建立
    public OrderService(){
        this.orderList = new ArrayList();
        this.mealList = new ArrayList();
        this.mealList.add(new Meal("hamburger", 150, "This is delicious"));
        this.mealList.add(new Meal("juice", 60, "make for apple"));
        this.mealList.add(new Meal("soup", 100, "warm your hard"));
        this.orderList.add(new Order(1, "Bill", mealList));
    }

    // 回傳所有訂單
    public List<Order> getAllOrders(){
        return orderList;
    }

    // 依照seq取得該單總金額
    public int getOrderTotalPrice(int seq){
        int count = 0;
        for(Order order :orderList){
            if(order.getSeq() == seq){
                count += order.getTotalPrice();
            }
        }
        return count;
    }

    //依照seq取得訂單資料
    public Order getOrderById(int seq){
        for(Order order: orderList){
            if(order.getSeq() == seq){
                return order;
            }
        }
        return  null;
    }

    //新增訂單
    public Order createOrder(Order newOrder){
        orderList.add(newOrder);
        return newOrder;
    }

    //依照seq修改訂單
    public Order updateOrder(int seq, Order updateOrder){
        for(Order order: orderList){
            if(order.getSeq() == seq){
                order.setTotalPrice(updateOrder.getTotalPrice());
                order.setWaiter(updateOrder.getWaiter());
                order.setMealList(updateOrder.getMealList());
                return updateOrder;
            }
        }
        return null;
    }

    //依照seq刪除訂單
    public Order deleteOrder(int seq){
        for(Order order: orderList){
            if(order.getSeq() == seq){
                orderList.remove(order);
                return order;
            }
        }
        return null;
    }
}
