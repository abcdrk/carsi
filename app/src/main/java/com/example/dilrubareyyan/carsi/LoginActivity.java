package com.example.dilrubareyyan.carsi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by dilrubareyyan on 12/08/17.
 */

public class LoginActivity extends Activity{

    Button btnLogin;
    Button btnFacebook;
    Button btnCreateAccount;
    EditText etUserName;
    EditText etPassword;
    ImageView ivDeal;
    ImageView ivLogo;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etUserName = findViewById(R.id.etUserNamex);
        etPassword = findViewById(R.id.etPasswordx);
        ivDeal = findViewById(R.id.ivDealx);
        ivLogo = findViewById(R.id.ivLogox);
        btnLogin = findViewById(R.id.btnLoginx);
        btnCreateAccount = findViewById(R.id.btnCreateAccountx);
        btnFacebook = findViewById(R.id.btnFacebookx);


        // LOGIN BUTTON
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                etPassword.setTypeface( Typeface.DEFAULT );
                Intent login = new Intent(LoginActivity.this, MainPageActivity.class);
                startActivity(login);
            }
        });

        // LOGIN WITH FACEBOOK BUTTON
        btnFacebook.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent login = new Intent(LoginActivity.this, MainPageActivity.class);
                startActivity(login);
            }
        });

        // CREATE AN ACCOUNT BUTTON
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Trying to give an click effect but not so successfull.
                btnCreateAccount.setTextColor(Color.WHITE);
                Intent createAccount = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(createAccount);
            }
        });


    }
}
