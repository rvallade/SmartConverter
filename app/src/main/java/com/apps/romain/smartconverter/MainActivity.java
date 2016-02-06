package com.apps.romain.smartconverter;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView zone1 = null;
    TextView zone2 = null;
    Spinner units1 = null;
    Spinner units2 = null;
    boolean isDirect = true;
    boolean deleteTextViewContent = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zone1 = (TextView) findViewById(R.id.zone1);
        zone2 = (TextView) findViewById(R.id.zone2);
        initializeListeneners();

        initSpinner();
    }

    private void initializeListeneners() {
        zone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // zone1 bold, zone2 normal
                zone1.setTypeface(zone1.getTypeface(), Typeface.BOLD);
                zone2.setTypeface(zone2.getTypeface(), Typeface.NORMAL);
                deleteTextViewContent = true;
                isDirect = true;
            }
        });

        zone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // zone1 bold, zone2 normal
                zone1.setTypeface(zone1.getTypeface(), Typeface.NORMAL);
                zone2.setTypeface(zone2.getTypeface(), Typeface.BOLD);
                deleteTextViewContent = true;
                isDirect = false;
            }
        });

        Button button0 = (Button) findViewById(R.id.button0);
        addListenerToButton(button0, "0");

        Button button1 = (Button) findViewById(R.id.button1);
        addListenerToButton(button1, "1");

        Button button2 = (Button) findViewById(R.id.button2);
        addListenerToButton(button2, "2");

        Button button3 = (Button) findViewById(R.id.button3);
        addListenerToButton(button3, "3");

        Button button4 = (Button) findViewById(R.id.button4);
        addListenerToButton(button4, "4");

        Button button5 = (Button) findViewById(R.id.button5);
        addListenerToButton(button5, "5");

        Button button6 = (Button) findViewById(R.id.button6);
        addListenerToButton(button6, "6");

        Button button7 = (Button) findViewById(R.id.button7);
        addListenerToButton(button7, "7");

        Button button8 = (Button) findViewById(R.id.button8);
        addListenerToButton(button8, "8");

        Button button9 = (Button) findViewById(R.id.button9);
        addListenerToButton(button9, "9");

        Button buttonCE = (Button) findViewById(R.id.buttonCE);
        buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zone1.setText("");
                zone2.setText("");
                isDirect = true;
                deleteTextViewContent = false;
            }
        });
        Button buttonDEL = (Button) findViewById(R.id.buttonDEL);
        buttonDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLastCharOfTextViewWithFocus();
            }
        });
    }

    private void removeLastCharOfTextViewWithFocus() {
        // we need to remove the last entry of either zone1 or zone2
        String fullText;
        if (isDirect) {
            fullText = zone1.getText().toString();
        } else {
            fullText = zone2.getText().toString();
        }
        //fullText = fullText.substring()
    }

    private void addListenerToButton(Button button, final String charToAdd) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumberToCorrectTextView(charToAdd);
                doConvert();
            }
        });
    }

    private void addNumberToCorrectTextView(String charToAdd) {
        // in case we need to delete the content after having selected a new zone
        if (deleteTextViewContent) {
            zone1.setText("");
            zone2.setText("");
            deleteTextViewContent = false;
        }
        if (isDirect) {
            zone1.setText(zone1.getText() + charToAdd);
        } else {
            zone2.setText(zone2.getText() + charToAdd);
        }
    }

    private void doConvert() {
        // here we need to convert based on what zone1 and zone2 contents
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
