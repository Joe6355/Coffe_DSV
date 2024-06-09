package com.example.coffe_dsv;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private int itemProduct;
    private String itemName;
    private int itemImageResource;

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
                    break;
                case "cappuccino":
                    fragment = new CappuccinoFragment();
                    itemProduct = 2;
                    itemName = "Cappuccino";
                    itemImageResource = R.drawable.cappuchhino;
                    break;
                case "raf":
                    fragment = new RafFragment();
                    itemProduct = 3;
                    itemName = "Raf";
                    itemImageResource = R.drawable.americano;
                    break;
                case "americano":
                    fragment = new AmericanoFragment();
                    itemProduct = 4;
                    itemName = "Americano";
                    itemImageResource = R.drawable.americano;
                    break;
                case "flatWhite":
                    fragment = new FlatWhiteFragment();
                    itemProduct = 5;
                    itemName = "Flat White";
                    itemImageResource = R.drawable.americano;
                    break;
                case "macchiato":
                    fragment = new macchiatoFragment();
                    itemProduct = 6;
                    itemName = "Macchiato";
                    itemImageResource = R.drawable.americano;
                    break;
                case "lungo":
                    fragment = new LungoFragment();
                    itemProduct = 7;
                    itemName = "Lungo";
                    itemImageResource = R.drawable.americano;
                    break;
                case "brave":
                    fragment = new BraveFragment();
                    itemProduct = 8;
                    itemName = "Brave";
                    itemImageResource = R.drawable.americano;
                    break;
                case "pancakes":
                    fragment = new PancakesFragment();
                    itemProduct = 9;
                    itemName = "Pancakes";
                    itemImageResource = R.drawable.americano;
                    break;
                case "fritter":
                    fragment = new FritterFragment();
                    itemProduct = 10;
                    itemName = "Fritter";
                    itemImageResource = R.drawable.americano;
                    break;
                case "sandwiches":
                    fragment = new SandwichFragment();
                    itemProduct = 11;
                    itemName = "Sandwiches";
                    itemImageResource = R.drawable.americano;
                    break;
                case "omelet":
                    fragment = new OmletFragment();
                    itemProduct = 12;
                    itemName = "Omelet";
                    itemImageResource = R.drawable.americano;
                    break;
                case "zerno1":
                    fragment = new Zerno1Fragment();
                    itemProduct = 13;
                    itemName = "Zerno1";
                    itemImageResource = R.drawable.americano;
                    break;
                case "zerno2":
                    fragment = new Zerno2Fragment();
                    itemProduct = 14;
                    itemName = "Zerno2";
                    itemImageResource = R.drawable.americano;
                    break;
                case "cup":
                    fragment = new CupFragment();
                    itemProduct = 15;
                    itemName = "Cup";
                    itemImageResource = R.drawable.americano;
                    break;
                default:
                    Toast.makeText(this, "Неизвестный тип напитка", Toast.LENGTH_LONG).show();
                    return;
            }

            if (fragment != null) {
                fragmentTransaction.replace(R.id.frame_layout, fragment);
                fragmentTransaction.commit();
            }
        }
    }

    public void addToCart(View view) {
        Item item = new Item(itemProduct, itemName, itemImageResource);
        Order.items.add(item);
        Toast.makeText(this, "Товар добавлен в корзину", Toast.LENGTH_LONG).show();
    }
}
