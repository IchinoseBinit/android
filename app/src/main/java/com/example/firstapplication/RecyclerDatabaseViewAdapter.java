package com.example.firstapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerDatabaseViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Person> persons;
    Activity context;

    public RecyclerDatabaseViewAdapter(Activity context, ArrayList<Person> persons) {
        this.context = context;
        this.persons = persons;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View recyclerListItem = layoutInflater.inflate(R.layout.view_database_items, parent, false);
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(recyclerListItem) {
        };
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView idView = holder.itemView.findViewById(R.id.id_text);
        TextView nameView = holder.itemView.findViewById(R.id.name_text);
        TextView addressView = holder.itemView.findViewById(R.id.address_text);

        idView.setText(String.valueOf(persons.get(position).getId()));
        nameView.setText(persons.get(position).getName());
        addressView.setText(persons.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
