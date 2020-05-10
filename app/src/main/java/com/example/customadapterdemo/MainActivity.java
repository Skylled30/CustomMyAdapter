package com.example.customadapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    UserListAdapter adapter;
    ListView listView;

    Button sort_btn_sex;
    Button sort_btn_name;
    Button sort_btn_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        sort_btn_name = findViewById(R.id.name);
        sort_btn_phone = findViewById(R.id.phone_number);
        sort_btn_sex = findViewById(R.id.sex);

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

    public void onClick(View v){
        switch (v.getId()){
            case R.id.sex:
                adapter.sort_data("sex");
                break;
            case R.id.phone_number:
                adapter.sort_data("phone");
                break;
            case R.id.name:
                adapter.sort_data("name");
                break;
        }
        update_list();
    }

    public void update_list(){
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }
}
