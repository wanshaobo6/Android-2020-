package com.example.wsb.adapte;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wsb.MainActivity;
import com.example.wsb.R;
import com.example.wsb.UpdateFood;
import com.example.wsb.pojo.Food;

import java.util.ArrayList;
import java.util.List;
public class FoodAdapter extends ArrayAdapter<Food> {

        CheckBox dishCheck;
        LinearLayout linearLayout;

        Button update;
        double count = 0.00;

        private Context context;

        private List<Food> foods = new ArrayList<>();
        private Food food;



        private int resourceId;
        public FoodAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<Food> objects) {
            super(context, textViewResourceId, objects);
            resourceId = textViewResourceId;

            this.context=context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            food = getItem(position);
            foods.add(food);
            //LayoutInflater的inflate()方法接收3个参数：需要实例化布局资源的id、ViewGroup类型视图组对象、false
            //false表示只让父布局中声明的layout属性生效，但不会为这个view添加父布局
            View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            //获取实例

           TextView foodname = (TextView) view.findViewById(R.id.tv_name);
           TextView foodprice = view.findViewById(R.id.tv_price);
            //设置菜名价格
            foodname.setText(food.getFoodname());
            foodprice.setText(food.getFoodprice()+"");



            //dishCheck = view.findViewById(R.id.dish_check);
            update = view.findViewById(R.id.btn_update);
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =  new Intent(context, UpdateFood.class);
                    intent.putExtra("foodId",food.get_id()+"");
                    context.startActivity(intent);
                    MainActivity activity = (MainActivity) context;
                    activity.finish();
                }
            });
            //linearLayout.setOnClickListener(new LinearLayout.OnClickListener() {
               // @Override
                //public void onClick(View view) {

//                    Log.d("video",video.getVideoname());
//                    Intent intent =  new Intent(context,VideoActivity.class);
//                    intent.putExtra("name",video.getVideoname());
//                    context.startActivity(intent);
//                    VideoActivity activity = (VideoActivity) context;
//                    activity.finish();

//                AlertDialog alertDialog1 = new AlertDialog.Builder(view.getContext())
//                        .setTitle("添加提示")//标题
//                        .setMessage("您已添加此商品")//内容
//                        .setIcon(R.mipmap.ic_launcher)//图标
//                        .create();
//                alertDialog1.show();

               // }
           // });


            return view;
        }
    }

