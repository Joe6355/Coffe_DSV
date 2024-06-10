package com.example.coffe_dsv;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private int itemProduct;
    private String itemName;
    private int itemImageResource;
    private double itemPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        String drinkType = getIntent().getStringExtra("drink_type");

        if (drinkType != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Fragment fragment = null;

            switch (drinkType) {
                case "latte":
                    fragment = new LatteFragment();
                    itemProduct = 1;
                    itemName = "Latte";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 5.0;
                    break;
                case "cappuccino":
                    fragment = new CappuccinoFragment();
                    itemProduct = 2;
                    itemName = "Cappuccino";
                    itemImageResource = R.drawable.cappuchhino;
                    itemPrice = 4.5;
                    break;
                case "raf":
                    fragment = new RafFragment();
                    itemProduct = 3;
                    itemName = "Raf";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 6.0;
                    break;
                case "americano":
                    fragment = new AmericanoFragment();
                    itemProduct = 4;
                    itemName = "Americano";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 3.5;
                    break;
                case "flatWhite":
                    fragment = new FlatWhiteFragment();
                    itemProduct = 5;
                    itemName = "Flat White";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 5.5;
                    break;
                case "macchiato":
                    fragment = new macchiatoFragment();
                    itemProduct = 6;
                    itemName = "Macchiato";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 4.0;
                    break;
                case "lungo":
                    fragment = new LungoFragment();
                    itemProduct = 7;
                    itemName = "Lungo";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 3.8;
                    break;
                case "brave":
                    fragment = new BraveFragment();
                    itemProduct = 8;
                    itemName = "Brave";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 5.0;
                    break;
                case "pancakes":
                    fragment = new PancakesFragment();
                    itemProduct = 9;
                    itemName = "Pancakes";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 7.0;
                    break;
                case "fritter":
                    fragment = new FritterFragment();
                    itemProduct = 10;
                    itemName = "Fritter";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 6.5;
                    break;
                case "sandwiches":
                    fragment = new SandwichFragment();
                    itemProduct = 11;
                    itemName = "Sandwiches";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 8.0;
                    break;
                case "omelet":
                    fragment = new OmletFragment();
                    itemProduct = 12;
                    itemName = "Omelet";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 5.5;
                    break;
                case "zerno1":
                    fragment = new Zerno1Fragment();
                    itemProduct = 13;
                    itemName = "Zerno1";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 12.0;
                    break;
                case "zerno2":
                    fragment = new Zerno2Fragment();
                    itemProduct = 14;
                    itemName = "Zerno2";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 15.0;
                    break;
                case "cup":
                    fragment = new CupFragment();
                    itemProduct = 15;
                    itemName = "Cup";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 2.5;
                    break;
                default:
                    Toast.makeText(this, "Неизвестный тип напитка", Toast.LENGTH_LONG).show();
                    return;
            }

            if (fragment != null) {
                fragmentTransaction.replace(R.id.frame_layout, fragment);
                fragmentTransaction.commit();
            }

            // Найти TextView и установить цену
            TextView itemPriceTextView = findViewById(R.id.item_price_main);
            if (itemPriceTextView != null) {
                itemPriceTextView.setText(String.format("$%.2f", itemPrice));
            }
        }
    }

    public void addToCart(View view) {
        Item item = new Item(itemProduct, itemName, itemImageResource, itemPrice);
        Order.items.add(item);
        Toast.makeText(this, "Товар добавлен в корзину", Toast.LENGTH_LONG).show();
    }
}
