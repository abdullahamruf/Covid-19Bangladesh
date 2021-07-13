package com.example.covid_19bangladesh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class chittagnag extends AppCompatActivity {
    ScrollView sv;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chittagnag);
        sv = findViewById(R.id.scrl);
        sv.setVisibility(View.VISIBLE);
        b1 =(Button) findViewById(R.id.ctg1);
        b2=(Button) findViewById(R.id.ctg2);
        b3=(Button) findViewById(R.id.ctg3);
        b4=(Button) findViewById(R.id.ctg4);
        b5=(Button) findViewById(R.id.ctg5);
        b6=(Button) findViewById(R.id.ctg6);
        b7=(Button) findViewById(R.id.ctg7);
        b8=(Button) findViewById(R.id.ctg8);
        b9=(Button) findViewById(R.id.ctg9);
        b10=(Button) findViewById(R.id.ctg10);
        b11=(Button) findViewById(R.id.ctg11);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),chittagangfind.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),chittagangfind.class));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),chittagangfind.class));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),chittagangfind.class));
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),chittagangfind.class));
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),chittagangfind.class));
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),chittagangfind.class));
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),chittagangfind.class));
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),chittagangfind.class));
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),chittagangfind.class));
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),chittagangfind.class));
            }
        });
    }
}