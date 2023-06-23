package com.example.firstapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);



        ArrayList myList = new ArrayList<Item>();
        myList.add(new Item(R.drawable.android_img, "Title 1", "This is a description"));
        myList.add(new Item(R.drawable.android_img, "Trekking", "Trekking is one of the most refreshing activity"));
        myList.add(new Item(R.drawable.android_img, "Photography", "It is one of the most pursued hobby around the world"));


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, myList);
        recyclerView.setAdapter(adapter);
    }
}
