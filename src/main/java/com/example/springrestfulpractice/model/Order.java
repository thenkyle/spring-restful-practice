package com.example.springrestfulpractice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// 使用 Lombok 加入 Getter, Setter, Constructor
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int seq;
    private int totalPrice;
    private String waiter;
    private List<Meal> mealList;

    public Order(int seq, String waiter, List<Meal> mealList){
        super();
        this.seq = seq;
        this.waiter = waiter;
        this.mealList = mealList;
    }

    // 取得meallist內的總金額
    public int getTotalPrice(){
        int count = 0;
        for (Meal meal: mealList){
            count += meal.getPrice();
        }
        return count;
    }
}
