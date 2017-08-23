package com.example.dilrubareyyan.carsi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by dilrubareyyan on 12/08/17.
 */

public class SignUp extends Activity {

    Button btnCreateAccountDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        btnCreateAccountDone = (Button) findViewById(R.id.btnCreateAccountDonex);


        btnCreateAccountDone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent createAccountDone = new Intent(SignUp.this, MainPageActivity.class);
                startActivity(createAccountDone);
            }
        });
    }
}
