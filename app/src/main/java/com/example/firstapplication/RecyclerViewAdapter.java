package com.example.firstapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    String[] title;
    String[] description;
    int[] image;
    Activity context;

    public RecyclerViewAdapter(Activity context, String[] title, String[] description, int[] image) {
        this.context = context;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View recyclerListItem = layoutInflater.inflate(R.layout.view_items, parent, false);
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(recyclerListItem) {
        };
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImageView img = holder.itemView.findViewById(R.id.image_view);
        TextView titleView = holder.itemView.findViewById(R.id.title_text);
        TextView descriptionView = holder.itemView.findViewById(R.id.description_text);

        img.setImageResource(image[position]);
        titleView.setText(title[position]);
        descriptionView.setText(description[position]);

    }

    @Override
    public int getItemCount() {
        return title.length;
    }
}
