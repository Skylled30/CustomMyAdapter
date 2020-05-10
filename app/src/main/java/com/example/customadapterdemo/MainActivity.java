package com.example.customadapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    UserListAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);

        ArrayList<User> users = new ArrayList<>();

        // TODO: реализовать загрузку данных из JSON-файла
        // который загрузить в папку assets
        String text = "data.json";
        byte[] buffer = null;
        InputStream is;
        try {
            is = getAssets().open(text);
            int size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str_data = new String(buffer);
        Gson gson = new Gson();
        Data data = gson.fromJson(str_data, Data.class);

        adapter = new UserListAdapter(this, data.users);

        listView.setAdapter(adapter);
    }
}
