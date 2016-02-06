package com.apps.romain.smartconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSpinner();
    }
    private void initSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.units1);
        Spinner spinner2 = (Spinner) findViewById(R.id.units2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.listDistances, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //reinitResultat();
                //EditText editText = (EditText) findViewById(R.id.txtNumberToConvert);
                //String selection = parentView.getItemAtPosition(position).toString();
                // must check if the selected value is "ft in ==> m"
                // in that case we are not waiting a decimal value but a String (ie: 6 14)
                /*if (selection.equals(getString(R.string.feetInchesToMeters))) {
                    //Toast.makeText(parentView.getContext(), "Selection: " + parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                    editText.setInputType(InputType.TYPE_CLASS_PHONE);
                } else {
                    editText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
                }*/
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });
        spinner2.setAdapter(adapter);
    }


}
