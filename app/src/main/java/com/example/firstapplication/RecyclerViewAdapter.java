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

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Item> items;
    Activity context;

    public RecyclerViewAdapter(Activity context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
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

        img.setImageResource(items.get(position).getImage());
        titleView.setText(items.get(position).getTitle());
        descriptionView.setText(items.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
