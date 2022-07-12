package com.example.database_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Product {

    private int id;
    private String title;
    private String description;
    private double price;

    public Product() {
    }

    public Product(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void save(Context context){
        SQLiteHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

//        database.execSQL("INSERT INTO products (title, description, price) VALUES ('"+this.title+"', '"+this.description+"', "+this.price+")");

        ContentValues values = new ContentValues();
        values.put(helper.COLUMN_TITLE, this.title);
        values.put(helper.COLUMN_DESCRIPTION, this.description);
        values.put(helper.COLUMN_PRICE, this.price);

        database.insert(helper.TABLE_PRODUCTS, null, values);

        database.close();
        helper.close();
    }

    public static ArrayList<Product> getAll(Context context){
        ArrayList<Product> products = new ArrayList<>();

        SQLiteHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM products", null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Product product = new Product();
            product.setId(cursor.getInt(0));
            product.setTitle(cursor.getString(1));
            product.setDescription(cursor.getString(2));
            product.setPrice( cursor.getDouble(3));

            products.add(product);

            cursor.moveToNext();
        }

        return products;
    }
}
