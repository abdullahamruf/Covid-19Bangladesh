package com.example.covid_19bangladesh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class health6 extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    ScrollView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health6);
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

        sv.setVisibility(View.VISIBLE);
        t1.setText("১. ফোলা জিহবাা");
        t2.setText("২. বুকে হালকা ব্যাথা");
        t3.setText("৩. চোখ জ্বালাপোড়া");
        t4.setText("৪. হাত ও পায়ের আঙ্গুলের রঙ ফ্যাকাশে হওয়া");
        t5.setText("৫. হাতের তালুতে জ্বালাপোড়া");
        t6.setText("৬. মাথা ব্যাথা");
        t7.setText("৭. গলা ব্যাথা");
        t8.setText("৮. পায়ের তালুতে লালচে ভাব");
        t9.setText("৯. ডায়রিয়া");
        t10.setText("১০. মুখে ঘাা");
        t11.setText("১১. চামড়ায় রাশ");
    }
}