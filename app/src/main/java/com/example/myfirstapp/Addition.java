package com.example.myfirstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

public class Addition extends AppCompatActivity {
    EditText n1,n2;
    TextView result, ratingsValue;
    Button addBtn, logout;
    TextView userName;
    RatingBar rb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        n1 = (EditText) findViewById(R.id.n1);
        n2 = (EditText) findViewById(R.id.n2);
        result = (TextView) findViewById(R.id.result);
        addBtn = (Button) findViewById(R.id.addBtn);
        userName = (TextView) findViewById(R.id.userName);
        rb = (RatingBar) findViewById(R.id.ratingBar);
        ratingsValue = (TextView) findViewById(R.id.ratingsValue);
        logout = (Button) findViewById(R.id.logout);
        Intent intent = getIntent();
        String uName = intent.getStringExtra("username");
        userName.setText("Welcome "+uName);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingsValue.setText("Rating : "+ rating);
            }
        });
    }

    public void add(View v){
        int a = Integer.parseInt(n1.getText().toString());
        int b = Integer.parseInt(n2.getText().toString());
        int c = a + b;
        result.setText("Sum of " + a + "+" + b + " = "+c);
    }

    public void userLogout(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(Addition.this);
        builder.setMessage("Are you sure you want to logout ?").setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Addition.this,userLogin.class);
                startActivity(intent);
            }
        }).setNegativeButton("Cancel",null);
        AlertDialog alert = builder.create();
        alert.show();
    }
}