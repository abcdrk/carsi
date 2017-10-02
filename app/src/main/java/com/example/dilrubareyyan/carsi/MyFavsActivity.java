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


public class MyFavsActivity extends Activity {

    final List<Item> items3 = new ArrayList<Item>();

    // Converts array-string to ArrayList<String>
    // List<String> Lines = Arrays.asList(getResources().getStringArray(R.array.subjects));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_favs);

        Button btnBackMyList = (Button) findViewById(R.id.btnMyListBackx);

        btnBackMyList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(MyFavsActivity.this, ProfileActivity.class);
                startActivity(goBack);
            }
        });

        final ListView mainList = (ListView) findViewById(R.id.lvMyListx);


        /**
         * Playing with ListView
         */
        items3.add(new Item("3 Günlük ihtiyaç, kolonya doldurumu!!", "Yılmaz Tekstil", "350.00"));


        // Setting the ArrayList adapters.
        final ItemAdapter adapter = new ItemAdapter(this, items3, getApplicationContext());

        mainList.setAdapter(adapter);






    }

}