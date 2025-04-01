package com.example.week4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.net.Uri;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText InputName, InputMSSV, InputClass, InputSDT, InputText;
    Button BtnSubmit, BtnClear, BtnSMS, BtnCall;
    RadioButton Btn1, Btn2, Btn3, Btn4;
    CheckBox CheckBox1, CheckBox2, CheckBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        InputName = findViewById(R.id.InputName);
        InputMSSV = findViewById(R.id.InputMSSV);
        InputClass = findViewById(R.id.InputClass);
        InputSDT = findViewById(R.id.InputSDT);
        InputText= findViewById(R.id.InputText);

        BtnSubmit = findViewById(R.id.BtnSubmit);
        BtnClear = findViewById(R.id.BtnClear);
        BtnSMS = findViewById(R.id.BtnSMS);
        BtnCall = findViewById(R.id.BtnCall);

        // Ánh xạ RadioButton
        Btn1 = findViewById(R.id.Btn1);
        Btn2 = findViewById(R.id.Btn2);
        Btn3 = findViewById(R.id.Btn3);
        Btn4 = findViewById(R.id.Btn4);

        // Ánh xạ CheckBox
        CheckBox1 = findViewById(R.id.CheckBox1);
        CheckBox2 = findViewById(R.id.CheckBox2);
        CheckBox3 = findViewById(R.id.CheckBox3);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //khai bao intent
                Intent intent = new Intent(MainActivity.this, Log_in.class);
                //lấy du lieu
                String Name = InputName.getText().toString().trim();
                String MSSV = InputMSSV.getText().toString().trim();
                String Class = InputClass.getText().toString().trim();
                String SDT = InputSDT.getText().toString().trim();
                String Text = InputText.getText().toString().trim();

                // Lấy thông tin năm học từ RadioButton
                String year = "";
                if (Btn1.isChecked()) {
                    year = "Năm 1";
                } else if (Btn2.isChecked()) {
                    year = "Năm 2";
                } else if (Btn3.isChecked()) {
                    year = "Năm 3";
                } else if (Btn4.isChecked()) {
                    year = "Năm 4";
                }

                // Lấy thông tin chuyên ngành từ CheckBox
                String major = "";
                if (CheckBox1.isChecked()) {
                    major += "MT - HTN ";
                }
                if (CheckBox2.isChecked()) {
                    major += "Điện tử ";
                }
                if (CheckBox3.isChecked()) {
                    major += "Mạng - Viễn thông";
                }

                //dong goi du lieu
                Bundle bundle = new Bundle();
                bundle.putString("InputName", Name);
                bundle.putString("InputMSSV", MSSV);
                bundle.putString("InputClass", Class);
                bundle.putString("InputSDT", SDT);
                bundle.putString("Year", year);
                bundle.putString("Major", major);
                bundle.putString("InputText", Text);

                //dua du lieu vao intent
                intent.putExtra("package",bundle);
                //khoi dong
                startActivity(intent);
            }
        });
        BtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputName.setText(" ");
                InputMSSV.setText(" ");
                InputClass.setText(" ");
                InputSDT.setText(" ");
                InputSDT.setText(" ");
                InputText.setText(" ");


                // Bỏ chọn CheckBox
                CheckBox1.setChecked(false);
                CheckBox2.setChecked(false);
                CheckBox3.setChecked(false);

                // Bỏ chọn RadioButton
                Btn1.setChecked(false);
                Btn2.setChecked(false);
                Btn3.setChecked(false);
                Btn4.setChecked(false);
            }
        });
        BtnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, call_activity.class);
                String phoneNumber = InputSDT.getText().toString().trim();
                String message = InputText.getText().toString().trim();

                if (!phoneNumber.isEmpty()) {
                    Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                    smsIntent.setData(Uri.parse("sms:" + phoneNumber));
                    smsIntent.putExtra("sms_body", message);
                    startActivity(smsIntent);
                }
            }
        });


        BtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(MainActivity.this, call_activity.class);
                startActivity(callIntent);

            }
        });
    }
}