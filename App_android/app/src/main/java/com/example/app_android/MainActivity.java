package com.example.app_android;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.text.Layout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] fruits = {
            "Apple", "Broccoli", "Carrot", "Cherries", "Grapes",
            "Lemon", "Raspberry", "Salad", "Strawberry", "Tomato"
    };

    String[] calories = {
            "52 Calories", "34 Calories", "41 Calories", "50 Calories", "67 Calories",
            "29 Calories", "52 Calories", "15 Calories", "33 Calories", "18 Calories"
    };

    int[] images = {
            R.drawable.apple, R.drawable.broccoli, R.drawable.carrot,
            R.drawable.cherries, R.drawable.grapes, R.drawable.lemon,
            R.drawable.raspberry, R.drawable.salad, R.drawable.strawberry, R.drawable.tomato
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fruits) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView textView = view.findViewById(android.R.id.text1);

                // Set hình ảnh
                int imgSize = 120;
                Drawable drawable = getResources().getDrawable(images[position]);
                drawable.setBounds(0, 0, imgSize, imgSize);
                textView.setCompoundDrawables(drawable, null, null, null);
                textView.setCompoundDrawablePadding(20);

                String fruit = fruits[position];
                String calo = calories[position];
                String fullText = fruit + "\n" + calo;

                SpannableString spannable = new SpannableString(fullText);

                // Canh phải dòng calories
                spannable.setSpan(
                        new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE),
                        fruit.length() + 1, // Dữ liệu calories bắt đầu từ đây
                        fullText.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );

                int margin = 40; // Điều chỉnh lề theo nhu cầu của bạn
                spannable.setSpan(
                        new android.text.style.LeadingMarginSpan.Standard(margin),
                        fruit.length() + 1,
                        fullText.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );

                textView.setText(spannable);
                textView.setTextSize(18);
                textView.setPadding(40, 60, 40, 60);

                return view;
            }


        };
        listView.setAdapter(adapter);
        listView.setDividerHeight(30); // Giãn dòng
    }
}
