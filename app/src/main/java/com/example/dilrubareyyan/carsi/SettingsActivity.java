package com.example.dilrubareyyan.carsi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import static com.example.dilrubareyyan.carsi.R.id.btnLogOut;


public class SettingsActivity extends AppCompatActivity {


    Button btnLogOut;
    private FirebaseAuth mAuth;

    final List<Item> items3 = new ArrayList<Item>();

    // Converts array-string to ArrayList<String>
    // List<String> Lines = Arrays.asList(getResources().getStringArray(R.array.subjects));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        Button btnBackSettings = (Button) findViewById(R.id.btnSettingsBackx);

        btnBackSettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(com.example.dilrubareyyan.carsi.SettingsActivity.this, ProfileActivity.class);
                startActivity(goBack);
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
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title_settings);

        mTitle.setText(R.string.settings);


        btnLogOut = (Button) findViewById(R.id.btnLogOut);

        mAuth = FirebaseAuth.getInstance();

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent goBack = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(goBack);
            }
        });

    }

}