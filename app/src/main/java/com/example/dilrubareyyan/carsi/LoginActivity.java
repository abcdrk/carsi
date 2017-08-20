package com.example.dilrubareyyan.carsi;

import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dilrubareyyan on 12/08/17.
 */

public class LoginActivity extends Activity{
    Button btnLogin;
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


        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                etPassword.setTypeface( Typeface.DEFAULT );
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btnCreateAccount.setTextColor(Color.WHITE);
                Intent createAccount = new Intent(LoginActivity.this, SignUp.class);
                startActivity(createAccount);
            }
        });


    }
}
