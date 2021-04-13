package com.example.simplelistviewandcustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ActivityOne extends AppCompatActivity {

    ListView listView;
    String[] countries = {"Pakistan", "Iran", "UAE" ,"India","Brazil","Saudi Arabia", "China", "US", "UK"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        listView = findViewById(R.id.listview);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,countries);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index = position;
                Toast.makeText(getApplicationContext(),"You clicked "+ countries[index],Toast.LENGTH_SHORT).show();
            }
        });

    }
}