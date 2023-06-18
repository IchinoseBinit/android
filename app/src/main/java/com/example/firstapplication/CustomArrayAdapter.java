package com.example.firstapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomArrayAdapter extends ArrayAdapter<String> {
    String[] title;
    String[] description;
    int[] image;
    Activity context;
    public CustomArrayAdapter(Activity context, String[] title, String[] description, int[] image) {
        super(context, R.layout.view_items, title);
        this.title = title;
        this.description = description;
        this.image = image;
        this.context = context;
    }

    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.view_items, null, true);

        ImageView img = rowView.findViewById(R.id.image_view);
        TextView titleView = rowView.findViewById(R.id.title_text);
        TextView descriptionView = rowView.findViewById(R.id.description_text);

        img.setImageResource(image[position]);
        titleView.setText(title[position]);
        descriptionView.setText(description[position]);
        return  rowView;
    }


}
