package com.example.dilrubareyyan.carsi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.dilrubareyyan.carsi.R.menu.menu_main;

public class MainPageActivity extends AppCompatActivity {

    final List<Item> items = new ArrayList<Item>();
    final List<Item> items2 = new ArrayList<Item>();

    // Converts array-string to ArrayList<String>
    // List<String> Lines = Arrays.asList(getResources().getStringArray(R.array.subjects));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        final ListView mainList = (ListView) findViewById(R.id.main_list);
        final Button need = (Button) findViewById(R.id.need);
        final Button surplus = (Button) findViewById(R.id.surplus);

        /**
         * Playing with ListView
         */
        items.add(new Item("3 Günlük ihtiyaç, kolonya doldurumu!!", false,"Yılmaz Tekstil", 4.99));
        items.add(new Item("Sanayiye kalifiye eleman lazim", true,"Yılmaz Tekstil",3.4));
        items.add(new Item("Dugme dikecek eleman, evden is de alinir", true,"Yılmaz Tekstil",49.9));
        items.add(new Item("Bagcilar merkez ayik olsun herkes!", false,"Yılmaz Tekstil",9.4));
        items.add(new Item("Umraniyede depo bosaltma", true,"Yılmaz Tekstil",77.7));
        items.add(new Item("Hali yikama uzun vadeli eleman",false,"Yılmaz Tekstil",90.45));
        items.add(new Item("Oyuncak bebek saci yikama. 900 tl pesin.",false,"Yılmaz Tekstil",56.77));
        items.add(new Item("3 Günlük ihtiyaç, kolonya doldurumu!!", false,"Yılmaz Tekstil",234.66));
        items.add(new Item("Sanayiye kalifiye eleman lazim", true,"Yılmaz Tekstil",4888.55));
        items.add(new Item("Dugme dikecek eleman, evden is de alinir", true,"Yılmaz Tekstil",4.67));
        items.add(new Item("Bagcilar merkez ayik olsun herkes!", false,"Yılmaz Tekstil",94.00));
        items.add(new Item("Bagcilar merkez ayik olsun herkes!", false,"Yılmaz Tekstil",94.00));
        items.add(new Item("Bagcilar merkez ayik olsun herkes!", false,"Yılmaz Tekstil",94.00));
        items.add(new Item("Bagcilar merkez ayik olsun herkes!", false,"Yılmaz Tekstil",94.00));
        items.add(new Item("Bagcilar merkez ayik olsun herkes!", false,"Yılmaz Tekstil",94.00));
        items.add(new Item("Bagcilar merkez ayik olsun herkes!", false,"Yılmaz Tekstil",94.00));

        items2.add(new Item("HOOOOOO",false,"Yılmaz Tekstil",4.00));
        items2.add(new Item("HOOoooooOOOO",false,"Yılmaz Tekstil",4.99));
        items2.add(new Item("HOOOOOO",false,"Yılmaz Tekstil",90.4));
        items2.add(new Item("HOOOoooooOOO",false,"Yılmaz Tekstil",74.88));
        items2.add(new Item("HOOOOOO",false,"Yılmaz Tekstil",345.45));
        items2.add(new Item("olacak",true,"Yılmaz Tekstil",58.60));
        items2.add(new Item("olacak",true,"Yılmaz Tekstil",567.90));
        items2.add(new Item("olacak",true,"Yılmaz Tekstil",45.80));
        items2.add(new Item("olacak",true,"Yılmaz Tekstil",885.00));
        items2.add(new Item("olacak",true,"Yılmaz Tekstil",444.40));
        items2.add(new Item("olacak",true,"Yılmaz Tekstil",50.40));
        items2.add(new Item("olacak",true,"Yılmaz Tekstil",123.40));
        items2.add(new Item("olacak",true,"Yılmaz Tekstil",942.00));
        items2.add(new Item("olacak",true,"Yılmaz Tekstil",55.55));
        items2.add(new Item("Emirin tbaletine yukledik",true,"Emir Tekstil",300.00));
        items2.add(new Item("Emirin tbaletine yukledik",true,"Emir Tekstil",300.00));
        items2.add(new Item("Emirin tbaletine yukledik",true,"Emir Tekstil",300.00));
        items2.add(new Item("Emirin tbaletine yukledik",true,"Emir Tekstil",300.00));
        items2.add(new Item("Emirin tbaletine yukledik",true,"Emir Tekstil",300.00));
        items2.add(new Item("Emirin tbaletine yukledik",true,"Emir Tekstil",300.00));
        items2.add(new Item("Emirin tbaletine yukledik",true,"Emir Tekstil",300.00));
        items2.add(new Item("Emirin tbaletine yukledik",true,"Emir Tekstil",300.00));



        // Setting the ArrayList adapters.
        final ItemAdapter adapter = new ItemAdapter(this, items);
        final ItemAdapter adapter2 = new ItemAdapter(this, items2);

        // Default display Eleman.
        mainList.setAdapter(adapter);


        /**
         * Setting TOOLBAR as ACTION BAR
         */
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Get access to the custom title view
        final TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        // The Eleman Page is introduced first.
        mTitle.setText(R.string.header_eleman);


        /**
         * Setting BOTTOM NAVIGATION BAR
         */
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_eleman:
                                mTitle.setText(R.string.header_eleman);
                                mainList.setAdapter(adapter);
                                need.setText("Eleman arıyorum");
                                surplus.setText("Iş arıyorum.");
                                break;

                            case R.id.action_nakliye:
                                mTitle.setText(R.string.header_nakliye);
                                mainList.setAdapter(adapter2);
                                need.setText("Nakliyeci Arıyorum");
                                surplus.setText("Nakliye yapıyorum");

                                need.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                    }
                                });
                                
                                break;

                            case R.id.action_urun:
                                mTitle.setText(R.string.header_urun);
                                mainList.setAdapter(adapter);
                                need.setText("Ürün arıyorum");
                                surplus.setText("Ürün satıyorum.");
                                break;

                            case R.id.action_depo:
                                mTitle.setText(R.string.header_depo);
                                mainList.setAdapter(adapter2);
                                need.setText("Depo Arıyorum");
                                surplus.setText("Depo kiralıyorum.");
                                break;

                            case R.id.action_profile:
                                Intent goToProfile = new Intent(MainPageActivity.this, ProfileActivity.class);
                                startActivity(goToProfile);
                                break;
                        }
                        return true;
                    }
                });

    }

    /**
     * Function adds actions to the toolbar.
     * (Inflater)
     */
    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(menu_main, menu);
        return true;
    }
}
