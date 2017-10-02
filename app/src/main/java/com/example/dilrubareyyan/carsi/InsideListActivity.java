package com.example.dilrubareyyan.carsi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by dilrubareyyan on 04/09/17.
 */

public class InsideListActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inside_list_item);


        Bundle kutu = getIntent().getExtras();
        String header = kutu.getString("header");
        String price = kutu.getString("price");
        String supplier = kutu.getString("supplier");
        String location = kutu.getString("location");

        TextView tv = (TextView) findViewById(R.id.editText);
        TextView tv2 = (TextView) findViewById(R.id.editText2);
        TextView tv3 = (TextView) findViewById(R.id.editText3);
        TextView tv4 = (TextView) findViewById(R.id.editText4);


        tv2.setText(header);
        tv3.setText("Ücret: " + price);
        tv.setText(supplier);
        tv4.setText("Lokasyon: " + location);

        Button back = (Button) findViewById(R.id.btnBack2x);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InsideListActivity.this, MainPageActivity.class);
                startActivity(intent);
            }
        });

    }
}
