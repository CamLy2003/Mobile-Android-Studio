package com.example.app_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import java.util.*;

public class SecondActivity extends Activity {
    int[] photos = {
            R.drawable.boy, R.drawable.boy1, R.drawable.girl, R.drawable.girl1, R.drawable.boy2,
            R.drawable.girl2, R.drawable.girl3, R.drawable.boy3, R.drawable.boy4, R.drawable.boy5
    };

    String[] names = {"David", "Henry", "Anne", "Alice", "Issac", "Lily", "Ruby", "Liam", "Louis", "Lucas"};
    String[] studentIds = {"20014", "2015", "20016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = new ListView(this);
        DatabaseHelper dbHelper = new DatabaseHelper(this);

        // ✅ 1. Chèn dữ liệu mẫu nếu chưa có
        for (int i = 0; i < names.length; i++) {
            dbHelper.insertStudent(studentIds[i], names[i], photos[i]);
        }

        // ✅ 2. Lấy toàn bộ dữ liệu từ database
        ArrayList<HashMap<String, Object>> list = dbHelper.getAllStudents();

        // ✅ 3. Tạo adapter hiển thị danh sách
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                R.layout.item_student,
                new String[]{"photo", "name", "studentId"},
                new int[]{R.id.imageIcon, R.id.textName, R.id.textID}
        );

        listView.setAdapter(adapter);
        setContentView(listView);

        // ✅ 4. Khi click vào item → mở info_student
        listView.setOnItemClickListener((parent, view, position, id) -> {
            HashMap<String, Object> student = list.get(position);
            Intent intent = new Intent(SecondActivity.this, info_student.class);
            intent.putExtra("image", (int) student.get("photo"));
            intent.putExtra("name", (String) student.get("name"));
            intent.putExtra("studentId", (String) student.get("studentId"));
            startActivity(intent);
        });
    }
}
