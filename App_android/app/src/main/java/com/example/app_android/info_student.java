package com.example.app_android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class info_student extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_student);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textViewName = findViewById(R.id.textViewInfo);
        TextView textViewId = findViewById(R.id.textViewID);

        // Nhận dữ liệu từ Intent
        int imageResId = getIntent().getIntExtra("image", R.drawable.boy);
        String name = getIntent().getStringExtra("name");
        String studentId = getIntent().getStringExtra("studentId");

        // Hiển thị dữ liệu
        imageView.setImageResource(imageResId);
        textViewName.setText("Name: " + name);
        textViewId.setText("ID: " + studentId);
    }
//    loginButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            startActivity(new Intent(register.this, MainActivity.class));
//            finish();
//        }
//    });
}
