package com.example.dilrubareyyan.carsi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by dilrubareyyan on 12/08/17.
 */

public class LoginActivity extends Activity{

    //FIELDS FOR VIEWS AND WIDGETS
    Button btnLogin, btnFacebook, btnCreateAccount;
    EditText etUserMail, etPassword;

    private ProgressBar progressBar;
    ProgressDialog mProgressDialog;


    //FIREBASE AUTHENTICATION FIELDS
    private FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainPageActivity.class));
            finish();
        }

        // Set the view now
        setContentView(R.layout.login);

        etUserMail = findViewById(R.id.etUserMailx);
        etPassword = findViewById(R.id.etPasswordx);
        btnLogin = findViewById(R.id.btnLoginx);
        btnCreateAccount = findViewById(R.id.btnCreateAccountx);
        btnFacebook = findViewById(R.id.btnFacebookx);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //PROGRESS DIALOG CONTEXT XXXX
        mProgressDialog = new ProgressDialog(this);

        // XXXXXXXXXXXXXXX
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                //CHECKING USER PRESENCE
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if( user != null )
                {

                    Intent moveToHome = new Intent(LoginActivity.this, MainPageActivity.class);
                    moveToHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(moveToHome);

                }

            }
        };

        mAuth.addAuthStateListener(mAuthListener);

        // LOGIN BUTTON
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPassword.setTypeface( Typeface.DEFAULT );
                String email = etUserMail.getText().toString();
                final String password = etPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                loginUser();
                //authenticate user
//                mAuth.signInWithEmailAndPassword(email, password)
//                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                // If sign in fails, display a message to the user. If sign in succeeds
//                                // the auth state listener will be notified and logic to handle the
//                                // signed in user can be handled in the listener.
//                                progressBar.setVisibility(View.GONE);
//                                if (!task.isSuccessful()) {
//                                    // there was an error
//                                    if (password.length() < 6) {
//                                        etPassword.setError(getString(R.string.minimum_password));
//                                    } else {
//                                        Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
//                                    }
//                                } else {
//                                    Intent intent = new Intent(LoginActivity.this, MainPageActivity.class);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                            }
//                        });
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

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        mAuth.removeAuthStateListener(mAuthListener);
    }

    private void loginUser() {

        String userEmail, userPassword;

        userEmail = etUserMail.getText().toString().trim();
        userPassword = etPassword.getText().toString().trim();

        if( !TextUtils.isEmpty(userEmail) && !TextUtils.isEmpty(userPassword))
        {

            mAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if( task.isSuccessful())
                    {

                        mProgressDialog.dismiss();
                        Intent moveToHome = new Intent(LoginActivity.this, MainPageActivity.class);
                        moveToHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(moveToHome);

                    }else
                    {

                        Toast.makeText(LoginActivity.this, "Unable to login user", Toast.LENGTH_LONG).show();
                        mProgressDialog.dismiss();

                    }

                }
            });

        }else
        {

            Toast.makeText(LoginActivity.this, "Please enter user email and password", Toast.LENGTH_LONG).show();
            mProgressDialog.dismiss();

        }

    }
    private void updateUI(FirebaseUser user) {

    }
}
