package com.example.dilrubareyyan.carsi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        Button btnBackProfile = (Button) findViewById(R.id.btnProfileBackx);

        btnBackProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(ProfileActivity.this, MainPageActivity.class);
                startActivity(goBack);
            }
        });


        Button btnSettings = (Button) findViewById(R.id.btnSettingsx);

        btnSettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToSettings = new Intent(com.example.dilrubareyyan.carsi.ProfileActivity.this, SettingsActivity.class);
                startActivity(goToSettings);
            }
        });

        Button btnMyList = (Button) findViewById(R.id.btnMyListx);

        btnMyList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToMyList = new Intent(com.example.dilrubareyyan.carsi.ProfileActivity.this, MyListActivity.class);
                startActivity(goToMyList);
            }
        });



        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Back to home icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        // Get access to the custom title view
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        mTitle.setText(R.string.profile);

    }


}