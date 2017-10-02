package com.example.dilrubareyyan.carsi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by dilrubareyyan on 12/08/17.
 */

public class SignUpActivity extends Activity {

    Button btnCreateAccountDone;
    EditText etEmail;
    EditText etPass;
    EditText etName;

    DatabaseReference dbRef;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        btnCreateAccountDone = (Button) findViewById(R.id.btnCreateAccountDonex);
        etEmail = (EditText) findViewById(R.id.etCreateEmail);
        etPass = (EditText) findViewById(R.id.etCreatePassword);
        etName = (EditText) findViewById(R.id.etName);

        mAuth = FirebaseAuth.getInstance();
        dbRef = FirebaseDatabase.getInstance().getReference("users");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                // CHECK USER
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if( user != null){
                    Intent createAccountDone = new Intent(SignUpActivity.this, MainPageActivity.class);
                    createAccountDone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(createAccountDone);
                }

            }
        };

        btnCreateAccountDone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                createUserAccount();

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

    private void saveUserInfo(String email, String name){
        String userId = mAuth.getCurrentUser().getUid();

        dbRef.child(userId).setValue(new User(email, name));
    }

    private void createUserAccount() {

        final String email,pass;

        email = etEmail.getText().toString().trim();
        pass = etPass.getText().toString().trim();

        if ( !TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)){

            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    Toast.makeText(SignUpActivity.this, "Success", Toast.LENGTH_LONG);

                    if ( task.isSuccessful() ){
                        saveUserInfo(email, etName.getText().toString());
                        Intent createAccountDone = new Intent(SignUpActivity.this, SubjectLocationActivity.class);
                        createAccountDone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(createAccountDone);
                    }
                    else{
                        Toast.makeText(SignUpActivity.this, "Fail", Toast.LENGTH_LONG);
                    }
                }

            });
        }
    }
}
