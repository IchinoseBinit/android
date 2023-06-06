package com.example.firstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.second);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        int age = i.getIntExtra("age", 0);
        String address = i.getStringExtra("address");

        Log.d("details", "name " + name + ", age " + age + ", address " +address);
        TextView textView = findViewById(R.id.textView);
        textView.setText("name " + name + ", age " + age + ", address " +address);
        Button btn = findViewById(R.id.finish_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("result", name);
                setResult(1, i);
                finish();
            }
        });
    }

}
