package com.example.coffe_dsv;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.widget.Toast;

public class CorzinaActivity extends AppCompatActivity {

    private ImageView previewImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corzina2);

        ListView ordersList = findViewById(R.id.order_list);
        CartAdapter adapter = new CartAdapter(this, Order.items);
        ordersList.setAdapter(adapter);

        previewImage = findViewById(R.id.previewImage);

        // Обработчик нажатия на кнопку
        Button imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Проверяем, пуста ли корзина
                if (Order.items.isEmpty()) {
                    // Если корзина пуста, показываем сообщение через Toast
                    Toast.makeText(CorzinaActivity.this, "Добавьте что-нибудь в корзину", Toast.LENGTH_SHORT).show();
                } else {
                    // Если в корзине есть элементы, показываем изображение
                    previewImage.setImageResource(R.drawable.oplata);
                    previewImage.setVisibility(View.VISIBLE);
                }
            }
        });

        // Обработчик нажатия на изображение
        previewImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Скрываем изображение при нажатии на него
                previewImage.setVisibility(View.GONE);
            }
        });
    }
}





