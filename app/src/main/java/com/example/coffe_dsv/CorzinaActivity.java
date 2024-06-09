package com.example.coffe_dsv;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;

public class CorzinaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corzina2);

        ListView ordersList = findViewById(R.id.order_list);
        CartAdapter adapter = new CartAdapter(this, Order.items);
        ordersList.setAdapter(adapter);
    }
}
