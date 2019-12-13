package com.example.wsb.dao;

import com.example.wsb.pojo.Food;

import java.util.List;

public interface Dao {
    List<Food> findAllFood();
    List<Food> findFoodByName(String foodname);
    long insertFood(Food food);
    int delectFood(String foodname);
    int updateFoodPrice(Food food);


}
