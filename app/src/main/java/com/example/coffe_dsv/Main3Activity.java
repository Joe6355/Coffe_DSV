package com.example.coffe_dsv;

import android.os.Bundle;

import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Main3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        String drinkType = getIntent().getStringExtra("drink_type");

        if (drinkType != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Fragment fragment = null; // Инициализируем переменную fragment по умолчанию

            if (drinkType.equals("latte")) {
                fragment = new LatteFragment();
            } else if (drinkType.equals("cappuccino")) {
                fragment = new CappuccinoFragment();
            }  // Добавьте другие варианты напитков здесь

            // Отображаем фрагмент только если он был инициализирован
            if (fragment != null) {
                fragmentTransaction.replace(R.id.frame_layout, fragment);
                fragmentTransaction.commit();
            } else {
                // Обработка ситуации, когда фрагмент не был инициализирован
                // Например, отображение сообщения об ошибке
            }
        }
    }
}