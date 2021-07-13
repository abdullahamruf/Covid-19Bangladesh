package com.example.covid_19bangladesh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class alldivision extends AppCompatActivity {
CardView dhaka,ctg,raj,shy,rang,mym,khu,bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alldivision);
       dhaka=(CardView)findViewById(R.id.dhaka);
        ctg=(CardView)findViewById(R.id.ctg);
        khu=(CardView)findViewById(R.id.khulna);
        raj=(CardView)findViewById(R.id.raj);
        shy=(CardView)findViewById(R.id.shylet);
        rang=(CardView)findViewById(R.id.rangpur);
        mym=(CardView)findViewById(R.id.myn);
       bar=(CardView)findViewById(R.id.barisal);
       dhaka.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(), alldhakadivison.class));
           }
       });
       khu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), khulnadivison.class));
            }
        });
       rang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), rangpur.class));
            }
        });
       mym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), mymenshing.class));
            }
        });

        raj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), rajsahi.class));
            }
        });
       ctg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),chittagnag.class));
            }
        });
        bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), barisal.class));
            }
        });
        shy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), shylet.class));
            }
        });




    }
}