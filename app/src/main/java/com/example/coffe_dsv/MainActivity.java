package com.example.coffe_dsv;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;

    private ImageView imageViewBanner;
    private List<Integer> imageList;
    private Handler handler = new Handler();
    private Runnable runnable;
    private int currentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageButton btn_logout = findViewById(R.id.logout_btn);

        mFirebaseAuth = FirebaseAuth.getInstance();

        imageViewBanner = findViewById(R.id.imageButton_promotion);
        imageList = new ArrayList<>();
        imageList.add(R.drawable.zactavka1);
        imageList.add(R.drawable.zactavka6);
        imageList.add(R.drawable.zactavka5);

        // Установить первое изображение
        imageViewBanner.setImageResource(imageList.get(currentIndex));

        // Автоматическая смена изображений
        runnable = new Runnable() {
            @Override
            public void run() {
                currentIndex = (currentIndex + 1) % imageList.size();
                imageViewBanner.setImageResource(imageList.get(currentIndex));
                handler.postDelayed(this, 3000); // Менять изображения каждые 3 секунды
            }
        };

        handler.postDelayed(runnable, 3000);

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
        } else if (view.getId() == R.id.image_button_bascet) {
            intent = new Intent(this, CorzinaActivity.class);
        } else {
            intent = new Intent(this, MainActivity.class);
            return;
        }

        if (intent != null) {
            startActivity(intent);

        }

    }

    public void logout(View view) {
        mFirebaseAuth.signOut();
        if (view.getId() == R.id.logout_btn) {
            Intent intent = new Intent(this, LogInActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();


        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}
