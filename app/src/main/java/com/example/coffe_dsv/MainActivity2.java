package com.example.coffe_dsv;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.content.Intent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private Button btn_fragmentLatte,btn_fragmentCappuccino;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coffee);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;



        });
    }

    public void onLatteButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "latte");
        startActivity(intent);
    }
    public void onCappuccinoButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "cappuccino");
        startActivity(intent);
    }

}