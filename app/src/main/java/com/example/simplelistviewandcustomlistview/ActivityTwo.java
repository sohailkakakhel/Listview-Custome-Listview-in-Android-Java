package com.example.simplelistviewandcustomlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity {

    ListView listView;
    String title [] = {"Facebook","Instagram","Youtube","Snapchat","Skype","Messenger","Painterest"};
    int img []= {R.drawable.fb,R.drawable.insta,R.drawable.s10,R.drawable.snap,R.drawable.skype,R.drawable.msnger,R.drawable.paintrst};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        listView = findViewById(R.id.list);
        MyAdapter adapter;
        adapter = new MyAdapter(this,title,img);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ActivityTwo.this,"You clicked "+title[position],Toast.LENGTH_SHORT).show();

            }
        });
    }


    public class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String title [];
        int rimg [];

        public MyAdapter(Context context, String[] title, int[] rimg) {
            super(context, R.layout.list_item, R.id.imgListView,title);
            this.context = context;
            this.title = title;
            this.rimg = rimg;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView==null)
            {

                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            }
            ImageView img = convertView.findViewById(R.id.imgListView);
            TextView textView = convertView.findViewById(R.id.title);

            img.setImageResource(rimg[position]);
            textView.setText(title[position]);
            return convertView;
        }
    }

}