package com.example.covid_19bangladesh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class rangpur extends AppCompatActivity {
ScrollView sc;
    Button a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rangpur);
        sc=findViewById(R.id.scrl);
        sc.setVisibility(View.VISIBLE);
        a1=findViewById(R.id.rangpur1);
        a2=findViewById(R.id.rangpur2);
        a3=findViewById(R.id.rangpur3);
        a4=findViewById(R.id.kurigram);
        a5=findViewById(R.id.dinajpur);
        a6=findViewById(R.id.dinajpur1);
        a7=findViewById(R.id.lal);
        a8=findViewById(R.id.lal1);
        a9=findViewById(R.id.lal2);
        a10=findViewById(R.id.pancha);
        a11=findViewById(R.id.thakurgaon);
        a12=findViewById(R.id.nilphamari);
        a13=findViewById(R.id.gaibandha);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rangpurfind.class));
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rangpurfind.class));
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rangpurfind.class));
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rangpurfind.class));
            }
        });

        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rangpurfind.class));
            }
        });

        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rangpurfind.class));
            }
        });

        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rangpurfind.class));
            }
        });


        a8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rangpurfind.class));
            }
        });

        a9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rangpurfind.class));
            }
        });

        a10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rangpurfind.class));
            }
        });

        a11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rangpurfind.class));
            }
        });

        a12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rangpurfind.class));
            }
        });

        a13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rangpurfind.class));
            }
        });
    }
}