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
            } else if (drinkType.equals("raf")) {
                fragment = new RafFragment();
            } else if (drinkType.equals("americano")) {
                fragment = new AmericanoFragment();
            }else if (drinkType.equals("flatWhite")) {
                fragment = new FlatWhiteFragment();
            }else if (drinkType.equals("macchiato")) {
                fragment = new macchiatoFragment();
            }else if (drinkType.equals("lungo")) {
                fragment = new LungoFragment();
            }else if (drinkType.equals("brave")) {
                fragment = new LungoFragment();
            }else if (drinkType.equals("pancakes")) {
                fragment = new PancakesFragment();
            }else if (drinkType.equals("fritter")) {
                fragment = new FritterFragment();
            }else if (drinkType.equals("sandwiches")) {
                fragment = new SandwichFragment();
            }else if (drinkType.equals("omelet")) {
                fragment = new OmletFragment();
            }else if (drinkType.equals("zerno1")) {
                fragment = new Zerno1Fragment();
            }else if (drinkType.equals("zerno2")) {
                fragment = new Zerno2Fragment();
            }else if (drinkType.equals("cup")) {
                fragment = new CupFragment();
            }

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