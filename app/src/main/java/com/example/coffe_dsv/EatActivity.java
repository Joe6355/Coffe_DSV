package com.example.coffe_dsv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EatActivity extends Activity { 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    public void onPancakesButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "pancakes");
        startActivity(intent);
    }

    public void onFritterButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "fritter");
        startActivity(intent);
    }

    public void onSandwichesButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "sandwiches");
        startActivity(intent);
    }

    public void onOmeletButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "omelet");
        startActivity(intent);
    }
}

