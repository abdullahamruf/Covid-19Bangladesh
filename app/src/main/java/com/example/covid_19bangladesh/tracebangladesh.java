package com.example.covid_19bangladesh;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class tracebangladesh extends AppCompatActivity {


    // Array of strings for ListView Title
    String[] listviewTitle = new String[]{
            "ঢাকা", "চট্টগ্রাম", "বগুড়া", "সিলেট", "কুমিল্লা", "নারায়ণগঞ্জ", "ফরিদপুর", "খুলনা", "গাজীপুর",
            "কক্সবাজার", "নোয়াখালী", "বরিশাল", "যশোর", "দিনাজপুর", "ময়মনসিংহ", "মুন্সিগঞ্জ",
            "রংপুর", "কুষ্টিয়া", "টাঙ্গাইল", "রাজবাড়ী", "কিশোরগঞ্জ", "গোপালগঞ্জ", "ব্রাহ্মণবাড়িয়া",
            "নরসিংদী", "চাঁদপুর", "সুনামগঞ্জ", "সিরাজগঞ্জ", "লক্ষ্মীপুর", "ঝিনাইদহ", "ফেনী",
            "হবিগঞ্জ", "শরিয়তপুর", "মৌলভীবাজার", "জামালপুর", "মানিকগঞ্জ", "পটুয়াখালী", "চুয়াডাঙ্গা",
            "মাদারিপুর", "পাবনা", "নড়াইল", "নওগাঁ", "ঠাকুরগাঁও", "গাইবান্ধা", "নীলফামারী",
            "জয়পুরহাট", "নাটোর", "সাতক্ষীরা", "পিরোজপুর", "রাঙামাটি", "মাগুরা",
            "বাগেরহাট", "বরগুনা", "কুড়িগ্রাম", "লালমনিরহাট", "ভোলা", "বান্দরবান", "নেত্রকোণা",
            "চাঁপাইনবাবগঞ্জ", "ঝালকাঠি", "খাগড়াছড়ি", "পঞ্চগড়", "মেহেরপুর", "শেরপুর"

    };


    String[] listviewShortDescription = new String[]{
            "Total :100000", "Total :100000", "Total :100000", "Total :100000", "Total :100000",
            "Total :104", "Total :1400", "Total :100000", "Total :160000", "Total :100000",
            "Total :100000", "Total :100000", "Total :100000", "Total :100000", "Total :100000",
            "Total :100000", "Total :100000", "Total :100000", "Total :100000", "Total :100000",
            "Total :100000", "Total :100000", "Total :100000", "Total :100000", "Total :100000",
            "Total :180000", "Total :100000", "Total :100000", "Total :100000", "Total :100000",
            "Total :100000", "Total :100000", "Total :100000", "Total :100000", "Total :100000",
            "Total :100000", "Total :100000", "Total :100000", "Total :100000", "Total :100000",
            "Total :100000", "Total :100000", "Total :100000", "Total :100000", "Total :100000"
            , "Total :100000", "Total :100000", "Total :100000", "Total :100000", "Total :100000",
            "Total :100000", "Total :100000", "Total :100000", "Total :100000", "Total :100000",
            "Total :100000", "Total :100000", "Total :100000", "Total :886", "Total :100000",
            "Total :100000", "Total :100000", "Total :100000"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracebangladesh);
        Toast.makeText(this, "The List is Updated Every 7 Days", Toast.LENGTH_LONG).show();

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 63; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            // hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listcity, from, to);
        ListView androidListView = (ListView) findViewById(R.id.list_view);
        androidListView.setAdapter(simpleAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.map:
                startActivity(new Intent(getApplicationContext(), tracebd.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}