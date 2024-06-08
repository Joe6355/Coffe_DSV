package com.example.coffe_dsv;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000; // время показа загрузочного экрана (в миллисекундах)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, LogInActivity.class); // NextActivity - имя следующей страницы
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
