package com.example.covid_19bangladesh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class rajsahi extends AppCompatActivity {
    Button r1,r2,r3,r4,r5,p,j,nao,cha,bogura,siraj;
    ScrollView sc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajsahi);
        sc=findViewById(R.id.scrl);
        sc.setVisibility(View.VISIBLE);
        r1=findViewById(R.id.raj);
        r2=findViewById(R.id.raj1);
        r3=findViewById(R.id.raj2);
        r4=findViewById(R.id.raj3);
        r5=findViewById(R.id.raj4);
        p=findViewById(R.id.pabna);
        j=findViewById(R.id.joy);
        nao=findViewById(R.id.nao);
        cha=findViewById(R.id.cha);
        bogura=findViewById(R.id.bogura);
        siraj=findViewById(R.id.siraj);
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rajsahifind.class));
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rajsahifind.class));
            }
        });

        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rajsahifind.class));
            }
        });

        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rajsahifind.class));
            }
        });

        r5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rajsahifind.class));
            }
        });

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rajsahifind.class));
            }
        });

        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rajsahifind.class));
            }
        });

        nao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rajsahifind.class));
            }
        });

        bogura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rajsahifind.class));
            }
        });

        siraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),rajsahifind.class));
            }
        });

    }
}