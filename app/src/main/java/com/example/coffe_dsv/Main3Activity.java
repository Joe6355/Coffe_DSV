package com.example.coffe_dsv;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Main3Activity extends AppCompatActivity {

    private Item currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        String drinkType = getIntent().getStringExtra("drink_type");

        if (drinkType != null) {
            Fragment fragment = null;
            String name = "";
            int imageResId = 0;

            switch (drinkType) {
                case "latte":
                    fragment = new LatteFragment();
                    name = "Latte";
                    imageResId = R.drawable.flatwhite;
                    break;
                case "cappuccino":
                    fragment = new CappuccinoFragment();
                    name = "Cappuccino";
                    imageResId = R.drawable.cappuchhino;
                    break;
                case "raf":
                    fragment = new RafFragment();
                    name = "Raf";
                    imageResId = R.drawable.americano;
                    break;
                // Добавьте остальные случаи
                default:
                    Toast.makeText(this, "Неизвестный тип напитка", Toast.LENGTH_SHORT).show();
                    return;
            }

            currentItem = new Item(1, name, imageResId);  // id можно изменить в зависимости от логики

            if (fragment != null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, fragment);
                fragmentTransaction.commit();
            }
        }
    }

    public void addToCart(View view) {
        Order.items.add(currentItem);
        Toast.makeText(this, "Товар добавлен в корзину", Toast.LENGTH_LONG).show();
    }
}