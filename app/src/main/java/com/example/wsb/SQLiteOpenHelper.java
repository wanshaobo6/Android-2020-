package com.example.wsb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    private static final String DB_NAME = "my.db";
    private static final int DB_version = 1;


    public SQLiteOpenHelper(Context context) {
        super(context, DB_NAME,null,DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE food(_id INTEGER PRIMARY KEY AUTOINCREMENT,foodname TEXT(20),foodprice REAL,count INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
