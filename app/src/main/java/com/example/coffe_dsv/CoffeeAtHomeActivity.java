package com.example.coffe_dsv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class CoffeeAtHomeActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coffee_at_home);


        ImageButton b_logout = findViewById(R.id.lgbt_btn);

        mFirebaseAuth = FirebaseAuth.getInstance();

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

    public void blogout(View view) {
        mFirebaseAuth.signOut();
        if (view.getId() == R.id.lgbt_btn) {
            Intent intent = new Intent(this, LogInActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    }
}