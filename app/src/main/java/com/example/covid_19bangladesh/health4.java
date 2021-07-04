package com.example.covid_19bangladesh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class health4 extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,tsp,t21;
    ScrollView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health4);
        sv=findViewById(R.id.sc);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        t8=findViewById(R.id.t8);
        tsp=findViewById(R.id.ts);
        t21=findViewById(R.id.t21);

        sv.setVisibility(View.VISIBLE);
        tsp.setText("***পূর্বের(মৃদু উপসর্গ,মাঝারি উপসর্গ) উপসর্গের সাথে***");
        t1.setText("১.তীব্র শ্বাসকষ্ট");
        t2.setText("২.কিছুই খেতে না পারা");
        t3.setText("৩.পানিশূন্য হয়ে পড়া।");
        t4.setText("৪.বারবার বমি হতে থাকা।");
        t5.setText("৫.অসংলগ্ন কথাবার্তা বলা/বিভ্রান্তি/অর্ধচেতন/অবচেতন");
        t6.setText("৬.চোখে সমস্যা (যেমনঃ চোখ থেকে পানি পড়া, ফোলা চোখ ইত্যাদি)");
        t7.setText("৭.নীলচে চেহারা/ঠোঁট/জিভ");

        t21.setText("=> রোগীকে যত দ্রুত সম্ভব হাসপাতালে ভর্তি করতে হবে।");
    }
}