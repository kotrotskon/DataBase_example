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

    public Product(Context context, int id){
        SQLiteHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        Cursor cursor = database.query(SQLiteHelper.TABLE_PRODUCTS, SQLiteHelper.PRODUCTS_COLUMN, "id = ?", new String[]{String.valueOf(id)}, null, null, null);

        cursor.moveToFirst();

        this.id = id;
        this.title = cursor.getString(1);
        this.description = cursor.getString(2);
        this.price = cursor.getDouble(3);

        database.close();
        helper.close();
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

    public void update(Context context, String title, String description, double price){
        SQLiteHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(helper.COLUMN_TITLE, title);
        values.put(helper.COLUMN_DESCRIPTION, description);
        values.put(helper.COLUMN_PRICE, price);

        database.update(SQLiteHelper.TABLE_PRODUCTS, values, "id = ?", new String[]{String.valueOf(this.id)});

        database.close();
        helper.close();
    }

    public void delete(Context context){
        SQLiteHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        database.delete(SQLiteHelper.TABLE_PRODUCTS, "id = ?", new String[]{String.valueOf(this.id)});

        database.close();
        helper.close();
    }

    public static ArrayList<Product> getAll(Context context){
        ArrayList<Product> products = new ArrayList<>();

        SQLiteHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

//        Cursor cursor = database.rawQuery("SELECT * FROM products", null);
        Cursor cursor = database.query(SQLiteHelper.TABLE_PRODUCTS, SQLiteHelper.PRODUCTS_COLUMN, null, null, null, null, null);


        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Product product = new Product();
            product.id = cursor.getInt(0);
            product.title = cursor.getString(1);
            product.description = cursor.getString(2);
            product.price = cursor.getDouble(3);

            products.add(product);

            cursor.moveToNext();
        }

        database.close();
        helper.close();

        return products;
    }
}
