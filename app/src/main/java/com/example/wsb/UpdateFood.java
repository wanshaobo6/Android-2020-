package com.example.wsb;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.wsb.dao.Dao;
import com.example.wsb.dao.DaoImpl;
import com.example.wsb.pojo.Food;

public class UpdateFood extends Activity {
    TextView foodname;
    TextView foodprice;
    Button add;
    int foodId;

    SQLiteOpenHelper helper;
    SQLiteDatabase sqLiteDatabase;

    Food food;

    Dao foodDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();

        helper = new SQLiteOpenHelper(this);

        sqLiteDatabase = helper.getReadableDatabase();

        Intent intent = getIntent();
        foodId = Integer.parseInt(intent.getStringExtra("foodId"));


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food=new Food(foodId,foodname.getText().toString(),Double.parseDouble(foodprice.getText().toString()),0);
                //dao初始化
                foodDao = new DaoImpl(helper,sqLiteDatabase);
                //修改菜品
                foodDao.updateFoodPrice(food);
                Intent intent = new Intent(UpdateFood.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }

    private void initView() {
        foodname = findViewById(R.id.et_name);
        foodprice = findViewById(R.id.et_price);
        add = findViewById(R.id.btn_add);
    }
}
