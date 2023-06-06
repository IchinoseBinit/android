package com.example.firstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends Activity {

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.calculator);

        Button btn  = findViewById(R.id.calculate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText principal = findViewById(R.id.principal);
                EditText rate = findViewById(R.id.rate);
                EditText time = findViewById(R.id.time);


                double pAmount = Double.parseDouble(principal.getText().toString());
                double rAmount = Double.parseDouble(rate.getText().toString());
                double tAmount = Double.parseDouble(time.getText().toString());

                double result = pAmount * rAmount * tAmount / 100;

                TextView resultView = findViewById(R.id.result);
                resultView.setText("Result: "+result);
            }
        });
    }
}
