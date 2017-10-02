package com.example.dilrubareyyan.carsi;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.dilrubareyyan.carsi.R.menu.menu_main;

public class MainPageActivity extends AppCompatActivity {


    final public static int ADD_ITEM_ACTIVITY_REQUEST_CODE = 1;
    public List<Item> items = new ArrayList<Item>();
    final public List<Item> items2 = new ArrayList<Item>();
    final public List<Item> items3 = new ArrayList<Item>();
    final List<Item> items4 = new ArrayList<Item>();
    final List<Item> items5 = new ArrayList<Item>();
    final List<Item> items6 = new ArrayList<Item>();
    final List<Item> items7 = new ArrayList<Item>();
    final List<Item> items8 = new ArrayList<Item>();
    ItemAdapter adapter;
    ListView mainList;
    // Converts array-string to ArrayList<String>
    // List<String> Lines = Arrays.asList(getResources().getStringArray(R.array.subjects));

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);


        mainList = (ListView) findViewById(R.id.main_list);
        final Button need = (Button) findViewById(R.id.need);
        final Button surplus = (Button) findViewById(R.id.surplus);



        /**
         * Playing with ListView
         */
        // ELEMAN
        items.add(new Item("3 Günlük ihtiyaç, kolonya doldurumu!!", "Burcu", "550.00"));
        items.add(new Item("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "Dilruba Reyyan ", "550.00"));
        items.add(new Item("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB", "Erenler Tekstil", "666.00"));
        items.add(new Item("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC", "Haydi Gidelim", "643.00"));
        items.add(new Item("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD", "Durmam buralarda ben", "109.00"));
        items.add(new Item("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "Dilruba Reyyan ", "550.00", "Bağcılar", "Tekstil"));
        items.add(new Item("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB", "Erenler Tekstil", "666.00", "Gungoren", "Hirdavat"));
        items.add(new Item("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC", "Haydi Gidelim", "643.00", "Etiler", "Tekstil"));
        items.add(new Item("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD", "Durmam buralarda ben", "109.00", "Cengelköy", "Nakliye"));
        items.add(new Item("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD", "Durmam buralarda ben", "109.00", "Cengelköy", "Nakliye"));
        items.add(new Item("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD", "Durmam buralarda ben", "109.00", "Cengelköy", "Nakliye"));
        items.add(new Item("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD", "Durmam buralarda ben", "109.00", "Cengelköy", "Nakliye"));

        items2.add(new Item("3 Günlük ihtiyaç, kolonya doldurumu!!", "Yılmaz Tekstil", "350.00"));

        // URUN FAZLA
        items3.add(new Item("3 Günlük ihtiyaç, kolonya doldurumu!!", "Yılmaz Tekstil", "350.00"));

        items4.add(new Item("3 Günlük ihtiyaç, kolonya doldurumu!!", "Yılmaz Tekstil", "350.00"));


        // NAKLIYE IHTIYAC
        items6.add(new Item("3 Günlük ihtiyaç, kolonya doldurumu!!", "Yılmaz Tekstil", "350.00"));

        // NAKLIYE VERECEK
        items5.add(new Item("3 Günlük ihtiyaç, kolonya doldurumu!!", "Yılmaz Tekstil", "350.00"));

        // DEPO FAZLA
        items7.add(new Item("3 Günlük ihtiyaç, kolonya doldurumu!!", "Yılmaz Tekstil", "350.00"));

        // DEPO IHTIYAC
        items8.add(new Item("3 Günlük ihtiyaç, kolonya doldurumu!!", "Yılmaz Tekstil", "350.00"));




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





        // Setting the ArrayList adapters.
        adapter = new ItemAdapter(this, items, getApplicationContext());
        final ItemAdapter adapter2 = new ItemAdapter(this, items2, getApplicationContext());
        final ItemAdapter adapter3 = new ItemAdapter(this, items3, getApplicationContext());
        final ItemAdapter adapter4 = new ItemAdapter(this, items4, getApplicationContext());
        final ItemAdapter adapter5 = new ItemAdapter(this, items5, getApplicationContext());
        final ItemAdapter adapter6 = new ItemAdapter(this, items6, getApplicationContext());
        final ItemAdapter adapter7 = new ItemAdapter(this, items7, getApplicationContext());
        final ItemAdapter adapter8 = new ItemAdapter(this, items8, getApplicationContext());

        // The Eleman Page is introduced first.
        mTitle.setText(R.string.header_eleman);

        mainList.setAdapter(adapter);


        Button btnAddItm = (Button) findViewById(R.id.btnAddItem);

        btnAddItm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add = new Intent(MainPageActivity.this, AddItemActivity.class);
                startActivityForResult(add, ADD_ITEM_ACTIVITY_REQUEST_CODE);
            }
        });



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
                                surplus.setText("Iş arıyorum");

                                need.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        mainList.setAdapter(adapter);
                                    }
                                });

                                surplus.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        mainList.setAdapter(adapter2);
                                    }
                                });

                                break;

                            case R.id.action_nakliye:
                                mTitle.setText(R.string.header_nakliye);
                                mainList.setAdapter(adapter6);
                                need.setText("Nakliyeci arıyorum");
                                surplus.setText("Nakliye yapıyorum");

                                need.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        mainList.setAdapter(adapter6);
                                    }
                                });

                                surplus.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        mainList.setAdapter(adapter5);
                                    }
                                });

                                break;

                            case R.id.action_urun:
                                mTitle.setText(R.string.header_urun);
                                mainList.setAdapter(adapter3);
                                need.setText("Ürün arıyorum");
                                surplus.setText("Ürün satıyorum");

                                need.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        mainList.setAdapter(adapter3);
                                    }
                                });

                                surplus.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        mainList.setAdapter(adapter4);
                                    }
                                });

                                break;

                            case R.id.action_depo:
                                mTitle.setText(R.string.header_depo);
                                mainList.setAdapter(adapter7);
                                need.setText("Depo arıyorum");
                                surplus.setText("Depo kiralıyorum");
                                need.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        mainList.setAdapter(adapter7);
                                    }
                                });

                                surplus.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        mainList.setAdapter(adapter8);
                                    }
                                });

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

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        items = new ArrayList<>();
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case ADD_ITEM_ACTIVITY_REQUEST_CODE: {
                if (resultCode == Activity.RESULT_OK) {
                    String header = data.getStringExtra("header");
                    String price = data.getStringExtra("price");
                    String supplier = data.getStringExtra("supplier");
                    String location = data.getStringExtra("location");

                    adapter.addItem(new Item(header, supplier, price, location, "Tekstil"));
                    Log.d("ben", header);
                    adapter.notifyDataSetChanged();
                }
                break;
            }
        }
    }
}
