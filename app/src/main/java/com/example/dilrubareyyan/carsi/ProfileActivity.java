package com.example.dilrubareyyan.carsi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ProfileActivity extends AppCompatActivity {

    Button btnLogOut, btnBackProfile, btnSettings, btnMyList, btnMyFavs;
    TextView mTitle, tvName;
    private FirebaseAuth mAuth;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        dbRef = FirebaseDatabase.getInstance().getReference("users");


        // BACK BUTTON
        btnBackProfile = (Button) findViewById(R.id.btnProfileBackx);

        btnBackProfile.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(ProfileActivity.this, MainPageActivity.class);
                startActivity(goBack);
            }
        });

        // SETTINGS BUTTON
        btnSettings = (Button) findViewById(R.id.btnSettingsx);

        btnSettings.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToSettings = new Intent(com.example.dilrubareyyan.carsi.ProfileActivity.this, SettingsActivity.class);
                startActivity(goToSettings);
            }
        });

        // MYLIST BUTTON
        btnMyList = (Button) findViewById(R.id.btnMyListx);

        btnMyList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToMyList = new Intent(com.example.dilrubareyyan.carsi.ProfileActivity.this, MyListActivity.class);
                startActivity(goToMyList);
            }
        });


        // FAVS BUTTON
        btnMyFavs = (Button) findViewById(R.id.btnFavs);

        btnMyFavs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToMyFavs = new Intent(com.example.dilrubareyyan.carsi.ProfileActivity.this, MyFavsActivity.class);
                startActivity(goToMyFavs);
            }
        });


        // LOGOUT BUTTON
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        mAuth = FirebaseAuth.getInstance();

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent goBack = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(goBack);
            }
        });

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.profile_toolbar);

        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Back to home icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        // Get access to the custom title view
        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        tvName = (TextView) findViewById(R.id.tvNamex);

        mTitle.setText(R.string.profile);

    }

    private void saveUserInfo(String email, String name){

        String userId = mAuth.getCurrentUser().getUid();

        dbRef.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                tvName.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }




}