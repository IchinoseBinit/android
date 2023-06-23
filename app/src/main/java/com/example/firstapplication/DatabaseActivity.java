package com.example.firstapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DatabaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);

        setContentView(R.layout.database_screen);

        EditText personName = findViewById(R.id.person_name);
        EditText personAddress = findViewById(R.id.person_address);
        Button btnSave = findViewById(R.id.btn_save);

        DatabaseHelper db = new DatabaseHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertData(personName.getText().toString(), personAddress.getText().toString());
                Toast.makeText(DatabaseActivity.this, "Successfully Data Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_database_view);

        Cursor cursor = db.selectData();
        ArrayList personArrayList = new ArrayList<Person>();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String address = cursor.getString(2);
            Person person = new Person(id, name, address);
            personArrayList.add(person);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerDatabaseViewAdapter adapter = new RecyclerDatabaseViewAdapter(this, personArrayList);
        recyclerView.setAdapter(adapter);
    }
}
