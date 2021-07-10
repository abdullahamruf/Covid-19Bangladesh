package com.example.covid_19bangladesh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class mymenshing extends AppCompatActivity {
ScrollView sc;
    Button m1,m2,m3,m4,m5,m6;
    Button n1,n2;
    Button j1,j2,j3,j4,j5,j6,j7,j8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymenshing);
        sc=findViewById(R.id.scrl);
        sc.setVisibility(View.VISIBLE);
        m1=findViewById(R.id.mymensing);
        m2=findViewById(R.id.mymensing1);
        m3=findViewById(R.id.mymensing2);
        m4=findViewById(R.id.mymensing3);
        m5=findViewById(R.id.mymensing4);
        m6=findViewById(R.id.mymensing5);
        n1=findViewById(R.id.netro);
        n2=findViewById(R.id.netro1);
        j1=findViewById(R.id.jamalpur);
        j2=findViewById(R.id.jamalpur1);
        j3=findViewById(R.id.jamalpur2);
        j4=findViewById(R.id.jamalpur3);
        j5=findViewById(R.id.jamalpur4);
        j6=findViewById(R.id.jamalpur5);
        j7=findViewById(R.id.jamalpur6);
        j8=findViewById(R.id.sherpur);
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });
        j1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });
        j2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

        j3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

        j4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

        j5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

        j6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

        j7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

        j8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),mumfind.class));
            }
        });

    }
}