package com.example.database_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_addNewProduct = findViewById(R.id.btn_addNewProduct);

        btn_addNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewProductActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<Product> products = Product.getAll(MainActivity.this);

        for (Product product : products) {
            Log.d("PRODUCT", product.getTitle());
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        SQLiteHelper helper = new SQLiteHelper(MainActivity.this);
        SQLiteDatabase database = helper.getWritableDatabase();

        Cursor cursor = database.rawQuery("SELECT count(*) as count FROM products", null);
        cursor.moveToFirst();

        int count = cursor.getInt(0);

        Log.d("SQLite", count+"");
    }
}