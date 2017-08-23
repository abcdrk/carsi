package com.example.dilrubareyyan.carsi;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import io.apptik.widget.multiselectspinner.MultiSelectSpinner;

/**
 * Created by burcuozbas on 13/08/17.
 */

public class SubjectLocationActivity extends Activity {

    private Spinner subjectSpinner;
    private Spinner locationSpinner;



    @Override

    protected void onCreate(Bundle subjectSpinnerBundle) {
        super.onCreate(subjectSpinnerBundle);
        setContentView(R.layout.subject_location);




        // Subject Spinner

        addItemsToSubjectSpinner();

        addListenerToSubjectSpinner();

        //The array of subjects
        ArrayList<String> options = new ArrayList<>();
        options.add("Tekstil");
        options.add("Depo");
        options.add("Gıda");
        options.add("Pet Shop");
        options.add("Elektronik");
        options.add("Kuyumcu");
        options.add("Mobilya");
        options.add("Züccaciye");
        options.add("İnşaat");
        options.add("Eczane");



        MultiSelectSpinner multiSelectSpinner = (MultiSelectSpinner) findViewById(R.id.spSubjectx);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, options);

        multiSelectSpinner.setPrompt("@string/selectSubject");


        multiSelectSpinner
                .setListAdapter(adapter)

                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {

                    }
                })
                .setAllCheckedText("All types")
                .setAllUncheckedText("none selected")
                .setSelectAll(false)
                //deselects item
                .selectItem(2, false)
                .setMinSelectedItems(1)
                .setAllUncheckedText("Bir veya birden fazla alan seçebilirsiniz.");




        // Location Spinner


        addItemsToLocationSpinner();

        addListenerToLocationSpinner();

        // The array of locations
        ArrayList<String> options2 = new ArrayList<>();
        options2.add("İstanbul");
        options2.add("Ankara");
        options2.add("İzmir");
        options2.add("Tokat");
        options2.add("Sivas");
        options2.add("Elazığ");
        options2.add("İzmit");
        options2.add("Çanakkale");
        options2.add("Ağrı");
        options2.add("Hatay");


        MultiSelectSpinner multiSelectSpinner2 = (MultiSelectSpinner) findViewById(R.id.spLocationx);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, options2);

        multiSelectSpinner2.setPrompt("@string/selectLocation");


        multiSelectSpinner2
                .setListAdapter(adapter2)

                .setListener(new MultiSelectSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {

                    }
                })
                .setAllCheckedText("All types")
                .setAllUncheckedText("none selected")
                .setSelectAll(false)
                //deselects item
                .selectItem(2, false)
                .setMinSelectedItems(1)
                .setAllUncheckedText("Bir veya birden fazla konum seçebilirsiniz.");



        Button btnFinish = (Button) findViewById(R.id.btnFinishx);
        Button btnBack = (Button) findViewById(R.id.btnBackx);

        btnBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(SubjectLocationActivity.this, SignUp.class);
                startActivity(goBack);
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent finish = new Intent(SubjectLocationActivity.this, MainPageActivity.class);
                startActivity(finish);
            }
        });



    }


    public void addItemsToSubjectSpinner() {

        subjectSpinner = (Spinner) findViewById(R.id.spSubjectx);

        ArrayAdapter<CharSequence> subjectSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.subjects,
                android.R.layout.simple_spinner_item);

        subjectSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        subjectSpinner.setAdapter(subjectSpinnerAdapter);

    }

    public void addListenerToSubjectSpinner() {

        subjectSpinner = (Spinner) findViewById(R.id.spSubjectx);

        subjectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String itemSelectedInSpinner = parent.getItemAtPosition(pos).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void addItemsToLocationSpinner() {

        locationSpinner = (Spinner) findViewById(R.id.spLocationx);

        ArrayAdapter<CharSequence> locationSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.locations,
                android.R.layout.simple_spinner_item);

        locationSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationSpinnerAdapter);

    }

    public void addListenerToLocationSpinner() {

        locationSpinner = (Spinner) findViewById(R.id.spLocationx);

        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String itemSelectedInSpinner = parent.getItemAtPosition(pos).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}