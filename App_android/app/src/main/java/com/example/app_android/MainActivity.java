package com.example.app_android;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout = findViewById(R.id.frameLayout);

        ImageView centerIcon = findViewById(R.id.center_icon);

        // Lấy các layout chứa icon + text
        LinearLayout layoutCenter = findViewById(R.id.layout_center);
        LinearLayout layoutTop = findViewById(R.id.layout_top);
        LinearLayout layoutTopRight = findViewById(R.id.layout_top_right);
        LinearLayout layoutRight = findViewById(R.id.layout_right);
        LinearLayout layoutBottomRight = findViewById(R.id.layout_bottom_right);
        LinearLayout layoutBottom = findViewById(R.id.layout_bottom);
        LinearLayout layoutBottomLeft = findViewById(R.id.layout_bottom_left);
        LinearLayout layoutLeft = findViewById(R.id.layout_left);
        LinearLayout layoutTopLeft = findViewById(R.id.layout_top_left);

        // Đợi layout vẽ xong mới tính vị trí
        frameLayout.post(() -> {
            float centerX = frameLayout.getWidth() / 2f;
            float centerY = frameLayout.getHeight() / 2f;

            float radius = 400f;

            // Đặt icon trung tâm
            layoutCenter.setX(centerX - layoutCenter.getWidth() / 2f);
            layoutCenter.setY(centerY - layoutCenter.getHeight() / 2f);

            // Các layout chứa icon + text
            LinearLayout[] layouts = {
                    layoutTop, layoutTopRight, layoutRight, layoutBottomRight,
                    layoutBottom, layoutBottomLeft, layoutLeft, layoutTopLeft
            };

            int numberOfIcons = layouts.length;

            for (int i = 0; i < numberOfIcons; i++) {
                double angle = Math.toRadians(i * (360.0 / numberOfIcons));
                float x = (float) (centerX + radius * Math.cos(angle)) - layouts[i].getWidth() / 2f;
                float y = (float) (centerY + radius * Math.sin(angle)) - layouts[i].getHeight() / 2f;

                layouts[i].setX(x);
                layouts[i].setY(y);
            }
        });
    }
}
