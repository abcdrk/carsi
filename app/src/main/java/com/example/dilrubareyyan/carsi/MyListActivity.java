package com.example.dilrubareyyan.carsi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by burcuozbas on 27/08/17.
 */


public class MyListActivity extends Activity {

    final List<Item> items3 = new ArrayList<Item>();

    // Converts array-string to ArrayList<String>
    // List<String> Lines = Arrays.asList(getResources().getStringArray(R.array.subjects));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_list);

        Button btnBackMyList = (Button) findViewById(R.id.btnMyListBackx);

        btnBackMyList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(MyListActivity.this, ProfileActivity.class);
                startActivity(goBack);
            }
        });

        final ListView mainList = (ListView) findViewById(R.id.lvMyListx);


        /**
         * Playing with ListView
         */
        items3.add(new Item("3 Günlük ihtiyaç, kolonya doldurumu!!", false,"Yılmaz Tekstil", 4.99));
        items3.add(new Item("Sanayiye kalifiye eleman lazim", true,"Yılmaz Tekstil",3.4));
        items3.add(new Item("Dugme dikecek eleman, evden is de alinir", true,"Yılmaz Tekstil",49.9));
        items3.add(new Item("Bagcilar merkez ayik olsun herkes!", false,"Yılmaz Tekstil",9.4));
        items3.add(new Item("Umraniyede depo bosaltma", true,"Yılmaz Tekstil",77.7));
        items3.add(new Item("Hali yikama uzun vadeli eleman",false,"Yılmaz Tekstil",90.45));
        items3.add(new Item("Oyuncak bebek saci yikama. 900 tl pesin.",false,"Yılmaz Tekstil",56.77));
        items3.add(new Item("3 Günlük ihtiyaç, kolonya doldurumu!!", false,"Yılmaz Tekstil",234.66));
        items3.add(new Item("Sanayiye kalifiye eleman lazim", true,"Yılmaz Tekstil",4888.55));
        items3.add(new Item("Dugme dikecek eleman, evden is de alinir", true,"Yılmaz Tekstil",4.67));




        // Setting the ArrayList adapters.
        final ItemAdapter adapter = new ItemAdapter(this, items3);


        // Default display Eleman.
        mainList.setAdapter(adapter);






    }

}