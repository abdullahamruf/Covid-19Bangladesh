package com.example.covid_19bangladesh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class health2 extends AppCompatActivity {
ScrollView sv,sv1;
TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health2);
        sv=findViewById(R.id.sc);
        sv1=findViewById(R.id.sc1);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
       t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        t8=findViewById(R.id.t8);
        t9=findViewById(R.id.t9);
        t10=findViewById(R.id.t21);
        t11=findViewById(R.id.t22);
        t12=findViewById(R.id.t23);
        t13=findViewById(R.id.t24);
        t14=findViewById(R.id.t25);
        t15=findViewById(R.id.t26);
        t16=findViewById(R.id.t27);

        sv.setVisibility(View.VISIBLE);
        sv1.setVisibility(View.VISIBLE);
        t1.setText("১.জ্বর (১০০ ডিগ্রির নিচে)");
        t2.setText("২.শুকনা কাশি");
        t3.setText("৩.গলা ব্যাথাা");
        t4.setText("৪.ক্লান্তি/দুর্বলতা");
        t5.setText("৫.মাথা ব্যাথা");
        t6.setText("৬.পেশীতে ব্যাথা");
        t7.setText("৭.পাতলা পায়খানা, ডায়রিয়া, বমি");
        t8.setText("৮.মুখে স্বাদ না থাকাা");
        t9.setText("৯.নাকে গন্ধ না পাওয়া");

        t10.setText("=> কোভিড-১৯ আক্রান্ত রোগী/রোগীর সংস্পর্শে থাকা ব্যক্তি ১৪ দিন পর্যন্ত আইসোলেশনে থাকবেন চিকিৎসকের সিদ্ধান্ত অনুযায়ী সময়সীমা বেশি বা কম হতে পারে।");
        t11.setText("=> রোগীকে আলাদা কক্ষ ও আলাদা শৌচাগার ব্যবহার করতে হবে।");
        t12.setText("=> রোগীর তৈজসপত্র যেমন-থালা, গ্লাস, কাপ ইত্যাদি, তোয়ালে, বিছানার চাদর ইত্যাদি অন্য কারো সাথে ভাগাভাগি করে ব্যবহার করা যাবেনা।");
        t13.setText("=> রোগীকে প্রচুর পরিমাণে পানি পান করতে হবে।");
        t14.setText("=> রোগীকে প্রচুর পরিমাণে প্রোটিন ও ভিটামিন-সি যুক্ত ফল যেমনঃ লেবু, কমলা, মাল্টা, আমলকি প্রভৃতি খেতে হবে");
        t15.setText("=> একটি থার্মোমিটার দিয়ে শরীরের তাপমাত্রা পর্যবেক্ষণে রাখতে হবে।");
        t16.setText("=> যদি নতুন উপসর্গ দেখা দেয় বা আগের উপসর্গের অবনতি হয় তাহলে দ্রুত ডাক্তারের পরামর্শ নিতে হবে।");



    }
}