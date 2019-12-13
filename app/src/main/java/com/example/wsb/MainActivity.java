package com.example.wsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.wsb.adapte.FoodAdapter;
import com.example.wsb.dao.Dao;
import com.example.wsb.dao.DaoImpl;
import com.example.wsb.pojo.Food;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    //GitHub : https://github.com/wanshaobo6/Android-2020-
    
    SQLiteOpenHelper helper;
    SQLiteDatabase sqLiteDatabase;

    ListView lv_food;
    Button add;

    Dao foodDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new SQLiteOpenHelper(this);

        sqLiteDatabase = helper.getReadableDatabase();

        initView();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddFood.class);
                startActivity(intent);
                finish();
            }
        });



        //dao初始化
        foodDao = new DaoImpl(helper,sqLiteDatabase);
        //获取所有菜品
        List<Food> foods = foodDao.findAllFood();


        FoodAdapter dishAdapte = new FoodAdapter(MainActivity.this,R.layout.activity_foodlist,foods);
        ListView listView = findViewById(R.id.lv_food);
        listView.setAdapter(dishAdapte);



    }

    private void initView() {
        lv_food = findViewById(R.id.lv_food);
        add = findViewById(R.id.btn_add);

    }
}
