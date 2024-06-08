package com.example.coffe_dsv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;



        });
    }

    public void onButtonClick(View view) {
        Intent intent = null;

        if (view.getId() == R.id.button_coffe) {
            intent = new Intent(this, MainActivity2.class);
        } else if (view.getId() == R.id.button_eat) {
            intent = new Intent(this, EatActivity.class);
        } else if (view.getId() == R.id.button_coffe_at_home) {
            intent = new Intent(this, CoffeeAtHomeActivity.class);
        } else if (view.getId() == R.id.button_merchendise) {
            intent = new Intent(this, MerchndiseActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
            return;
        }

        if (intent != null) {
            startActivity(intent);

        }

    }
}