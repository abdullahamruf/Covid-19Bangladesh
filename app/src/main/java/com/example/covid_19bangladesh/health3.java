package com.example.covid_19bangladesh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class health3 extends AppCompatActivity {
    ScrollView sv,sv1;
    TextView t1,t2,t3,t4,t5,t6,t7,t10,t11,t12,t13,t14,t15,t16,tsp,t17,t18,t19,t20,t21,t22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health3);
        sv=findViewById(R.id.sc);
        sv1=findViewById(R.id.sc1);
        t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t3);
        t4=findViewById(R.id.t4);
        t5=findViewById(R.id.t5);
        t6=findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        tsp=findViewById(R.id.ts);
        t10=findViewById(R.id.t21);
        t11=findViewById(R.id.t22);
        t12=findViewById(R.id.t23);
        t13=findViewById(R.id.t24);
        t14=findViewById(R.id.t25);
        t15=findViewById(R.id.t26);
        t16=findViewById(R.id.t27);
        t17=findViewById(R.id.t28);
        t18=findViewById(R.id.t29);
        t19=findViewById(R.id.t30);
        t20=findViewById(R.id.t31);
        t21=findViewById(R.id.t32);
        t22=findViewById(R.id.t33);


        sv.setVisibility(View.VISIBLE);
        sv1.setVisibility(View.VISIBLE);

        tsp.setText("***পূর্বের(মৃদু উপসর্গ) উপসর্গের সাথে***");
        t1.setText("১.জ্বর (১০১-১০২ ডিগ্রি)");
        t2.setText("২.শরীরে শিরশিরে ভাব (নিয়মিত কাঁপুনিসহ)");
        t3.setText("৩.ভারি কাশিা");
        t4.setText("৪.শ্বাসকষ্ট (অক্সিজেন সেচুরেশন ৯৪% এর নীচে");
        t5.setText("৫.ক্লান্তি া");
        t6.setText("৬.শরীরে ব্যথা");
        t7.setText("৭.পেশীতে ব্যাথা");

        t10.setText("=> কোভিড-১৯ আক্রান্ত রোগী/রোগীর সংস্পর্শে থাকা ব্যক্তি ১৪ দিন পর্যন্ত আইসোলেশনে থাকবেন চিকিৎসকের সিদ্ধান্ত অনুযায়ী সময়সীমা বেশি বা কম হতে পারে।");
        t11.setText("=> রোগীকে আলাদা কক্ষ ও আলাদা শৌচাগার ব্যবহার করতে হবে।");
        t12.setText("=> রোগীর তৈজসপত্র যেমন-থালা, গ্লাস, কাপ ইত্যাদি, তোয়ালে, বিছানার চাদর ইত্যাদি অন্য কারো সাথে ভাগাভাগি করে ব্যবহার করা যাবেনা।");
        t13.setText("=> রোগীকে প্রচুর পরিমাণে পানি পান করতে হবে।");
        t14.setText("=> রোগীকে প্রচুর পরিমাণে প্রোটিন ও ভিটামিন-সি যুক্ত ফল যেমনঃ লেবু, কমলা, মাল্টা, আমলকি প্রভৃতি খেতে হবে।");
        t15.setText("=> একটি থার্মোমিটার দিয়ে শরীরের তাপমাত্রা পর্যবেক্ষণে রাখতে হবে।");
        t16.setText("=> পালস অক্সিমিটার দিয়ে অক্সিজেন স্যাচুরেশন পর্যবেক্ষণে রাখতে হবে।");

            t17.setText("** উপুর হয়ে শোয়া, নিদেন পক্ষে উপুর হতে না পারলে পাশ ফিরে শোয়া।");
            t18.setText("** ব্রিদিং এক্সারসাইজ করা।");
            t19.setText("** দিনে ২-৪ বার নিঃশ্বাসে গরম পানির ভাপ নেয়া।");
            t20.setText("** দিনে অন্তত ২/৩ কাপ গরম মসলা চা খাওয়া।");
            t21.setText("** দিনে একবার নাকে কালিজিরা ভিজানো পানির ড্রপ নেয়া।");
            t22.setText("** কালিজিরা, রসুন, মধু ইত্যাদি খাওয়া।");
    }
}