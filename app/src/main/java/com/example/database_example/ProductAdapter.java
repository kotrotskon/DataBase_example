package com.example.database_example;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter {

    private Context context;
    ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products){
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.product_row, parent, false);
        MyViewHolder item = new MyViewHolder(row);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).txtVw_title.setText(products.get(position).getTitle());
        ((MyViewHolder)holder).txtVw_description.setText(products.get(position).getDescription().substring(0, 200)+"...");
        ((MyViewHolder)holder).txtVw_price.setText(String.valueOf(products.get(position).getPrice()));

        int item_position = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShowProductActivity.class);
                intent.putExtra("product_id", products.get(item_position).getId());
                context.startActivity(intent);
            }
        });


        ((MyViewHolder)holder).btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditProductActivity.class);
                intent.putExtra("product_id", products.get(item_position).getId());
                context.startActivity(intent);
            }
        });

        ((MyViewHolder)holder).btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                products.get(item_position).delete(context);
                ((MainActivity)context).onStart();
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtVw_title;
        TextView txtVw_description;
        TextView txtVw_price;
        Button btn_edit;
        Button btn_delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtVw_title = itemView.findViewById(R.id.txtVw_title);
            txtVw_description = itemView.findViewById(R.id.txtVw_description);
            txtVw_price = itemView.findViewById(R.id.txtVw_price);
            btn_edit = itemView.findViewById(R.id.btn_edit);
            btn_delete = itemView.findViewById(R.id.btn_delete);
        }
    }
}
