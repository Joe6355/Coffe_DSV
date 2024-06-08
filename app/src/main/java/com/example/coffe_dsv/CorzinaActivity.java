package com.example.coffe_dsv;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class CorzinaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corzina);

        // Находим ListView в макете activity_corzina.xml
        ListView orders_list = findViewById(R.id.order_list);

        // Создаем экземпляр адаптера CartAdapter с текущим контекстом и списком элементов
        CartAdapter adapter = new CartAdapter(this, Order.items);

        // Устанавливаем адаптер для ListView
        orders_list.setAdapter(adapter);
    }
}