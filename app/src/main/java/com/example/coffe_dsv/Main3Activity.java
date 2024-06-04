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

    public int item_product;
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
                item_product = 1;
            } else if (drinkType.equals("cappuccino")) {
                fragment = new CappuccinoFragment();
                item_product = 2;
            } else if (drinkType.equals("raf")) {
                fragment = new RafFragment();
                item_product = 3;
            } else if (drinkType.equals("americano")) {
                fragment = new AmericanoFragment();
                item_product = 1;
            }else if (drinkType.equals("flatWhite")) {
                fragment = new FlatWhiteFragment();
                item_product = 1;
            }else if (drinkType.equals("macchiato")) {
                fragment = new macchiatoFragment();
                item_product = 1;
            }else if (drinkType.equals("lungo")) {
                fragment = new LungoFragment();
                item_product = 1;
            }else if (drinkType.equals("brave")) {
                fragment = new LungoFragment();
                item_product = 1;
            }else if (drinkType.equals("pancakes")) {
                fragment = new PancakesFragment();
                item_product = 1;
            }else if (drinkType.equals("fritter")) {
                fragment = new FritterFragment();
                item_product = 1;
            }else if (drinkType.equals("sandwiches")) {
                fragment = new SandwichFragment();
                item_product = 1;
            }else if (drinkType.equals("omelet")) {
                fragment = new OmletFragment();
                item_product = 1;
            }else if (drinkType.equals("zerno1")) {
                fragment = new Zerno1Fragment();
                item_product = 1;
            }else if (drinkType.equals("zerno2")) {
                fragment = new Zerno2Fragment();
                item_product = 1;
            }else if (drinkType.equals("cup")) {
                fragment = new CupFragment();
                item_product = 1;
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
    public void addToCart(View view){
        int item_id = item_product;
        Order.items_id.add(item_id);
        Toast.makeText(this, "Товар добавлен в корзину", Toast.LENGTH_LONG).show();
    }
}