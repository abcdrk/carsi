package com.example.dilrubareyyan.carsi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by dilrubareyyan on 02/10/17.
 */

public class AddItemActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        final EditText et1 = (EditText) findViewById(R.id.et1);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        final EditText et3 = (EditText) findViewById(R.id.et3);
        final EditText et4 = (EditText) findViewById(R.id.et4);
        final EditText et5 = (EditText) findViewById(R.id.et5);

        Button addComplete = (Button) findViewById(R.id.btnAddComplete);

        addComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String supplier = et1.getText().toString();
                final String header = et2.getText().toString();
                final String explenation = et3.getText().toString();
                final String location = et4.getText().toString();
                final String price = et5.getText().toString();

                Bundle kutu = new Bundle();
                kutu.putString("header", header);
                kutu.putString("price", price);
                kutu.putString("supplier", supplier);
                kutu.putString("location",location);
                kutu.putString("explenation",explenation);

                Intent resultIntent = new Intent();
                resultIntent.putExtras(kutu);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

    }
}
