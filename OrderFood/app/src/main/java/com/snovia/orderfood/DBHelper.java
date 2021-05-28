package com.snovia.orderfood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.snovia.orderfood.Models.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "mydatabase.db";
    final static int DBVersion = 2;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders " +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text," +
                        "price intt," +
                        "image int," +
                        "quantity integer," +
                        "description text," +
                        "foodName text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists orders");
        onCreate(db);
    }

    public boolean insertOrder(String name, String phone, int price, int image, int quantity, String desc, String foodName) {

        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("quantity", quantity);
        values.put("description", desc);
        values.put("foodName", foodName);
        long id = database.insert("orders", null, values);
        if (id <= 0) {
            return false;
        } else {
            return true;
        }
    }
    public ArrayList<OrderModel> getOrders(){
        ArrayList<OrderModel> orders= new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor =  database.rawQuery("Select id,foodName,image,price from orders",null);
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                OrderModel model = new OrderModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setOrderPrice(cursor.getInt(3)+"");
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }
    public Cursor getOrderById(int id){
        SQLiteDatabase database =this.getWritableDatabase();
        Cursor cursor =  database.rawQuery("Select * from orders",null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        return cursor;
    }
    public boolean updateOrder(String name, String phone, int price, int image, int quantity, String desc, String foodName,int id) {

        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("quantity", quantity);
        values.put("description", desc);
        values.put("foodName", foodName);
        long row = database.update("orders",values,"id="+id,null);
        if (row <= 0) {
            return false;
        } else {
            return true;
        }
    }
    public int deleteOrder(String id){
        SQLiteDatabase database =this.getWritableDatabase();
        return database.delete("orders","id="+id,null);
    }
}

