package com.example.covid_19bangladesh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class health1 extends AppCompatActivity {
TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t21;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health1);
      t1=  findViewById(R.id.t1);
        t2=  findViewById(R.id.t2);
        t3=  findViewById(R.id.t3);
        t4=  findViewById(R.id.t4);
        t5=  findViewById(R.id.t5);
        t6=  findViewById(R.id.t6);
        t7=  findViewById(R.id.t7);
        t8=  findViewById(R.id.t8);
        t9=  findViewById(R.id.t9);
        t10=  findViewById(R.id.t10);
        t11=  findViewById(R.id.t11);
        t21=findViewById(R.id.t21);

      t1.setText("১. জ্বর (৯৯ ডিগ্রি বা \n"+"তার বেশি)");
        t2.setText( "২.শুকনা কাশি");
        t3.setText( "৩.গলা ব্যাথা");
        t4.setText( "৪.শ্বাসকষ্ট");
        t5.setText( "৫.শরীর খারাপ লাগা");
        t6.setText( "৬.সর্দি ভাব");
        t7.setText( "৭.বুক ব্যাথা");
        t8.setText( "৮.মাথা ব্যাথা");
        t9.setText( "৯.পাতলা পায়খানা, ডায়রিয়া");
        t10.setText( "১০.মুখে স্বাদ না থাকা");
        t11.setText( "১১.নাকে গন্ধ না পাওয়া");
        t21.setText("পাশের উপসর্গসমূহের\n" +
                "অন্তত ২টি থাকলে\n" +
                "অথবা\n" +
                "মুখে স্বাদ বা নাকে গন্ধ না পেলে\n" +
                "দ্রুত করোনা পরীক্ষা করুন।");

    }
}