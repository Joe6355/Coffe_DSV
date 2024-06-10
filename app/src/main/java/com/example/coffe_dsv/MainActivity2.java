package com.example.coffe_dsv;

import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;

    private Button btn_fragmentLatte,btn_fragmentCappuccino;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coffee);

        ImageButton btn_logout = findViewById(R.id.lgbt_btn);

        mFirebaseAuth = FirebaseAuth.getInstance();


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
    public void onRafButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "raf");
        startActivity(intent);
    }
    public void onAmericanoButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "americano");
        startActivity(intent);
    }
    public void onFlatWhiteButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "flatWhite");
        startActivity(intent);
    }
    public void onMacchiatoButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "macchiato");
        startActivity(intent);
    }
    public void onLungoButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "lungo");
        startActivity(intent);
    }
    public void onBraveButtonClick(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("drink_type", "brave");
        startActivity(intent);
    }

    public void lgbt(View view) {
        mFirebaseAuth.signOut();
        if (view.getId() == R.id.lgbt_btn) {
            Intent intent = new Intent(this, LogInActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();


        }
    }

    public void onButtonClick(View view) {
        Intent intent = null;
        int id = view.getId();

        if (id == R.id.ImageButtonHome) {
            intent = new Intent(this, MainActivity.class);
        } else if (id == R.id.imageButtonBascet) {
            intent = new Intent(this, CorzinaActivity.class);
        } else if (id == R.id.lgbt_btn) {
            mFirebaseAuth.signOut();
            if (view.getId() == R.id.logout_btn) {
                intent = new Intent(this, LogInActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        }else {
            intent = new Intent(this, MainActivity.class);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }

}