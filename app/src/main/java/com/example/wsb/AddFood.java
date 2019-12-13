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

public class AddFood extends Activity {
    TextView foodname;
    TextView foodprice;
    Button add;

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


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food=new Food(foodname.getText().toString(),Double.parseDouble(foodprice.getText().toString()));
                //dao初始化
                foodDao = new DaoImpl(helper,sqLiteDatabase);
                //添加菜品
                foodDao.insertFood(food);
                Intent intent = new Intent(AddFood.this, MainActivity.class);
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
