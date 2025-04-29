package com.example.app_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class home extends AppCompatActivity {

    Button layoutFruit, layoutSocial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Tên file XML là activity_home.xml

        layoutFruit = findViewById(R.id.layoutFruit);
        layoutSocial = findViewById(R.id.layoutSocial);

        layoutFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fruitIntent = new Intent(home.this, MainActivity.class);
                startActivity(fruitIntent);
            }
        });

        layoutSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent socialIntent = new Intent(home.this, SecondActivity.class);
                startActivity(socialIntent);
            }
        });
    }
}
