package com.example.database_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ShowProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);

        TextView txtVw_title = findViewById(R.id.txtVw_title);
        TextView txtVw_description = findViewById(R.id.txtVw_description);
        TextView txtVw_price = findViewById(R.id.txtVw_price);

        Product product = new Product(ShowProductActivity.this, getIntent().getExtras().getInt("product_id"));

        txtVw_title.setText(product.getTitle());
        txtVw_description.setText(product.getDescription());
        txtVw_price.setText(String.valueOf(product.getPrice()));
    }
}