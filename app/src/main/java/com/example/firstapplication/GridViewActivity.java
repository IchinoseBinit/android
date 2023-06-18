package com.example.firstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

public class GridViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gridview);

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
        GridView gridView = findViewById(R.id.gridview);


        gridView.setAdapter(adapter);
    }

}
