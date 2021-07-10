package com.example.covid_19bangladesh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class health5 extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t21;
    ScrollView sv;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health5);
        img=findViewById(R.id.img2);
        sv=findViewById(R.id.sc);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        t8=findViewById(R.id.t8);
        t9=findViewById(R.id.t9);
        t10=findViewById(R.id.t10);
        t11=findViewById(R.id.t11);
        t12=findViewById(R.id.t12);
        t13=findViewById(R.id.t13);
        t21=findViewById(R.id.t21);
        sv.setVisibility(View.VISIBLE);
        t1.setText("১.ক্লান্তি");
        t2.setText("২.নিশ্বাস নিতে কষ্ট");
        t3.setText("৩.স্নায়বিক জটিলতা");
        t4.setText("৪.ঘুমের সমস্যা");
        t5.setText("৫.কথা মনে রাখতে কষ্ট হওয়া/ মনযোগে সমস্যা");
        t6.setText("৬.কাশি");
        t7.setText("৭.পেশীতে ব্যাথা বা মাথা ব্যাথা");
        t8.setText("৮.হৃৎস্পন্দন দ্রুত হয়ে যাওয়া");
        t9.setText("৯.বিষন্নতা/ উদ্বিগ্নতা");
        t10.setText("১০.র্যাশ হওয়া");
        t11.setText("১১. চুল পড়া");
        t12.setText("১২.মুখে স্বাদ না থাকা");
        t13.setText("১৩.নাকে গন্ধ না পাওয়া");

        t21.setText("=> দ্রুত ডাক্তারের পরামর্শ নিন।");
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}