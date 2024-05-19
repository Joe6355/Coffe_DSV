package com.example.coffe_dsv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CoffeeAtHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coffee_at_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onZerno1ButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "zerno1");
        startActivity(intent);
    }
    public void onZerno2ButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "zerno2");
        startActivity(intent);
    }
}