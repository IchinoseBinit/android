package com.example.firstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listview);

        String[] title = {
                "Title 1",
                "Trekking",
                "Photography",
        };
        String[] description = {
                "This is a description",
                "Trekking is one of the most refreshing activity",
                "It is one of the most pursued hobby around the world"
        };

        int[] img = {
                R.drawable.android_img,
                R.drawable.android_img,
                R.drawable.android_img,
        };

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.view_items, R.id.listview_text, names);

        CustomArrayAdapter adapter = new CustomArrayAdapter(this, title, description, img);
        ListView listView = findViewById(R.id.listview);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println("Hello world");
                String toShowTitle = title[position];
                Log.d("text", toShowTitle);

                Toast.makeText(ListviewActivity.this, toShowTitle, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
