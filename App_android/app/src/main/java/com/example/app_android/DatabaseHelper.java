package com.example.app_android;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "students.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "student";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_IMAGE = "imageRes";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_ID + " TEXT PRIMARY KEY, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_IMAGE + " INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Hàm kiểm tra sinh viên đã tồn tại hay chưa
    public boolean isStudentExists(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT 1 FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = ?", new String[]{id});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        return exists;
    }

    // Chỉ insert nếu chưa tồn tại
    public void insertStudent(String id, String name, int imageRes) {
        if (isStudentExists(id)) return; // Nếu đã có, không insert nữa

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, id);
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_IMAGE, imageRes);
        db.insert(TABLE_NAME, null, values);
    }
    public ArrayList<HashMap<String, Object>> getAllStudents() {
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, Object> item = new HashMap<>();
                item.put("studentId", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ID)));
                item.put("name", cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME)));
                item.put("photo", cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_IMAGE)));
                list.add(item);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

}
