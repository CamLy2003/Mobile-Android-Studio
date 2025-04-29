package com.example.app_android;

import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.*;

public class SecondActivity extends Activity {

    int[] icons = {
            R.drawable.facebook_icon_264986,
            R.drawable.instagram_icon_264992,
            R.drawable.twitter_icon_264995,
            R.drawable.telegram_icon_264994,
            R.drawable.linkedin_icon_264993,
            R.drawable.e_mail_icon_264991
    };

    String[] names = {
            "Facebook", "Instagram", "Twitter", "Telegram", "LinkedIn", "Email"
    };

    String[] since = {
            "Since 2004", "Since 2010", "Since 2006", "Since 2013", "Since 2003", "Since 1971"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = new ListView(this);

        ArrayList<HashMap<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            HashMap<String, Object> item = new HashMap<>();
            item.put("icon", icons[i]);
            item.put("title", names[i]);
            item.put("since", since[i]);
            list.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                R.layout.activity_second,
                new String[]{"icon", "title", "since"},
                new int[]{R.id.imageIcon, R.id.textTitle, R.id.textSince}
        );

        listView.setAdapter(adapter);
        setContentView(listView);
    }
}
