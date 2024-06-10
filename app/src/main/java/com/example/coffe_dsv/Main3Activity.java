package com.example.coffe_dsv;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Main3Activity extends AppCompatActivity {

    private int itemProduct;
    private String itemName;
    private int itemImageResource;
    private double itemPrice;
    private String getItemName;

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
                    itemName = "Латте";
                    getItemName = "Латте";
                    itemImageResource = R.drawable.latte;
                    itemPrice = 5.0;
                    break;
                case "cappuccino":
                    fragment = new CappuccinoFragment();
                    itemProduct = 2;
                    itemName = "Капучино";
                    getItemName = "Капучино";
                    itemImageResource = R.drawable.cappuchhino;
                    itemPrice = 4.5;
                    break;
                case "raf":
                    fragment = new RafFragment();
                    itemProduct = 3;
                    itemName = "Раф";
                    getItemName = "Раф";
                    itemImageResource = R.drawable.raf;
                    itemPrice = 6.0;
                    break;
                case "americano":
                    fragment = new AmericanoFragment();
                    itemProduct = 4;
                    itemName = "Американо";
                    getItemName = "Американо";
                    itemImageResource = R.drawable.americano;
                    itemPrice = 3.5;
                    break;
                case "flatWhite":
                    fragment = new FlatWhiteFragment();
                    itemProduct = 5;
                    itemName = "Флат вайт";
                    getItemName = "Флат вайт";
                    itemImageResource = R.drawable.flatwhite;
                    itemPrice = 5.5;
                    break;
                case "macchiato":
                    fragment = new macchiatoFragment();
                    itemProduct = 6;
                    itemName = "Маккиатоo";
                    getItemName = "Маккиато";
                    itemImageResource = R.drawable.macchiato;
                    itemPrice = 4.0;
                    break;
                case "lungo":
                    fragment = new LungoFragment();
                    itemProduct = 7;
                    itemName = "Лунго";
                    getItemName = "Лунго";
                    itemImageResource = R.drawable.lungo;
                    itemPrice = 3.8;
                    break;
                case "brave":
                    fragment = new BraveFragment();
                    itemProduct = 8;
                    itemName = "Брав";
                    getItemName = "Брав";
                    itemImageResource = R.drawable.breve;
                    itemPrice = 5.0;
                    break;
                case "pancakes":
                    fragment = new PancakesFragment();
                    itemProduct = 9;
                    itemName = "Блины";
                    getItemName = "Блины";
                    itemImageResource = R.drawable.pancakes;
                    itemPrice = 7.0;
                    break;
                case "fritter":
                    fragment = new FritterFragment();
                    itemProduct = 10;
                    itemName = "Оладьи";
                    getItemName = "Оладьи";
                    itemImageResource = R.drawable.fritter;
                    itemPrice = 6.5;
                    break;
                case "sandwiches":
                    fragment = new SandwichFragment();
                    itemProduct = 11;
                    itemName = "Бутерброд";
                    getItemName = "Бутерброд";
                    itemImageResource = R.drawable.sandwich;
                    itemPrice = 8.0;
                    break;
                case "omelet":
                    fragment = new OmletFragment();
                    itemProduct = 12;
                    itemName = "Омлет";
                    getItemName = "Омлет";
                    itemImageResource = R.drawable.omlet;
                    itemPrice = 5.5;
                    break;
                case "zerno1":
                    fragment = new Zerno1Fragment();
                    itemProduct = 13;
                    itemName = "Lebo Gold";
                    getItemName = "Lebo Gold";
                    itemImageResource = R.drawable.nopemerchendais;
                    itemPrice = 12.0;
                    break;
                case "zerno2":
                    fragment = new Zerno2Fragment();
                    itemProduct = 14;
                    itemName = "Noir Egoiste";
                    getItemName = "Noir Egoiste";
                    itemImageResource = R.drawable.nopemerchendais;
                    itemPrice = 15.0;
                    break;
                case "cup":
                    fragment = new CupFragment();
                    itemProduct = 15;
                    itemName = "Кружка";
                    getItemName = "Кружка";
                    itemImageResource = R.drawable.nopemerchendais;
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

            TextView itemNameTextView = findViewById(R.id.item_name_main);
            if (itemNameTextView != null) {
                itemNameTextView.setText(getItemName); // Установка имени товара в TextView
            }

        }
    }

    public void addToCart(View view) {
        Item item = new Item(itemProduct, itemName, itemImageResource, itemPrice);
        Order.items.add(item);
        Toast.makeText(this, "Товар добавлен в корзину", Toast.LENGTH_LONG).show();
    }
}
