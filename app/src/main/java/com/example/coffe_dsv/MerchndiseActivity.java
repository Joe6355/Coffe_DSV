package com.example.coffe_dsv;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MerchndiseActivity extends AppCompatActivity {
     private EditText cityEditText;
    private TextView weatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchndise);

        cityEditText = findViewById(R.id.cityEditText);
        Button getWeatherButton = findViewById(R.id.getWeatherButton);
        weatherTextView = findViewById(R.id.weatherTextView);

        getWeatherButton.setOnClickListener(v -> {
            String city = cityEditText.getText().toString().trim();
            if (!city.isEmpty()) {
                getWeather(city);
            } else {
                Toast.makeText(MerchndiseActivity.this, "Введите город", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getWeather(String city) {
        new Thread(() -> {
            try {
                String apiKey = "4d318f18b7e5e5c45539c93d792843e2"; // Вставьте свой ключ OpenWeatherMap
                String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + apiKey;

                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                reader.close();

                JSONObject jsonObject = new JSONObject(result.toString());
                double temperature = jsonObject.getJSONObject("main").getDouble("temp");

                runOnUiThread(() -> weatherTextView.setText("Температура: " + temperature + "°C"));

            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> Toast.makeText(MerchndiseActivity.this, "Ошибка получения данных", Toast.LENGTH_SHORT).show());
            }
        }).start();
    }















// ImageButton b_logout = findViewById(R.id.image_logout);




      //  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
      //      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
      //      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
     //       return insets;

      //  });


    //}






//    public void onCupClick(View view) {
//        Intent intent = new Intent(this, Main3Activity.class);
//        intent.putExtra("drink_type", "cup");
//        startActivity(intent);
//    }
//
//    public void blogout(View view) {
//        if (view.getId() == R.id.image_logout) {
//            Intent intent = new Intent(this, LogInActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
//            finish();
//        }
//    }
//
//    public void lgbt(View view) {
//        mFirebaseAuth.signOut();
//        if (view.getId() == R.id.image_logout) {
//            Intent intent = new Intent(this, LogInActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(intent);
//            finish();
//
//
//        }
//    }
//
//    public void onButtonClick(View view) {
//        Intent intent = null;
//        int id = view.getId();
//
//        if (id == R.id.ImageButtonHome) {
//            intent = new Intent(this, MainActivity.class);
//        } else if (id == R.id.imageButtonBascet) {
//            intent = new Intent(this, CorzinaActivity.class);
//        }else {
//            intent = new Intent(this, MainActivity.class);
//        }
//
//        if (intent != null) {
//            startActivity(intent);
//        }
//    }

}