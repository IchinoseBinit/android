package com.example.firstapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity  {

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        Log.d("Lifecycle test", "On create triggered");
        setContentView(R.layout.main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("hello world");
                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("name", "Binit");
                i.putExtra("age", 25);
                i.putExtra("address", "Dharan");
                startActivityForResult(i, 2);
            }
        });

        Button aviBtn = findViewById(R.id.avi_button);
        aviBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("name", "Abhishek");
                i.putExtra("age", 21);
                i.putExtra("address", "Sarlahi");
                startActivityForResult(i, 1);
            }


        });

        Button calcBtn = findViewById(R.id.calc_button);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(i);
            }


        });

        Button goToFragmentBtn = findViewById(R.id.fragment_button);
        goToFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(i);
            }
        });

        Button goToMenuBtn = findViewById(R.id.menu_button);
//        registerForContextMenu(goToMenuBtn);
        goToMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }

    public void showDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Hello");
        alertDialog.setMessage("This is from alert dialog");
//        alertDialog.setIcon();
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("yes clicked", "logged for yes button");
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("no clicked", "logged for no button");
            }
        });
        alertDialog.show();
    }

//    public void showMenu(View v) {
//        PopupMenu menu = new PopupMenu(this, v);
//        menu.setOnMenuItemClickListener(this);
//        menu.inflate(R.menu.menu);
//        menu.show();
//    }

//    @Override
//    public boolean onMenuItemClick(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.item1:
//                Log.d(item.toString(), "onMenuItemClicked: 1");
//                return true;
//            case R.id.item2:
//                Log.d(item.toString(), "onMenuItemClicked: 2");
//                return true;
//            case R.id.item3:
//                Log.d(item.toString(), "onMenuItemClicked: 3");
//                return true;
//            default:
//                return false;
//        }
//    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    public boolean onContextMenuItemSelected(MenuItem item) {
        Log.d(item.toString(), "onContextMenuItemSelected: ");
        switch (item.getItemId()) {
            case R.id.item1:
                Log.d(item.toString(), "onContextMenuItemSelected: Item 1");
                return true;


            case R.id.item2:
                Log.d(item.toString(), "onContextMenuItemSelected: Item 2");
                return true;


            case R.id.item3:
                Log.d(item.toString(), "onContextMenuItemSelected: Item 3");
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);

        TextView textView = findViewById(R.id.result_text_view);
        if (requestCode == 1) {
            String data = i.getStringExtra("result");

            Log.d("logger", data);
            textView.setText(data);

//            textView.isVis
        } else {
            textView.setText("");

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("test", "on start triggered");
    }

    @Override
    public  void onResume() {
        super.onResume();
        Log.d("test", "on resume triggered");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d("test", "on restart trigger");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("test", "on pause triggered");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("test", "on stop trigger");
    }

    @Override
    public  void onDestroy() {
        super.onDestroy();
        Log.d("test", "on destroy triggered");
    }

}
