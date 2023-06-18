package com.example.firstapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);


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

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, title, description, img);
        recyclerView.setAdapter(adapter);
    }
}
