package com.karenpownall.android.aca.temperatureconversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mFah;
    TextView mCel;
    TextView mKel;
    TextView mOutputTextView;
    Button mConvertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFah = (TextView) findViewById(R.id.fahText);
        mCel = (TextView) findViewById(R.id.celText);
        mKel = (TextView) findViewById(R.id.kelText);
        mOutputTextView = (TextView) findViewById(R.id.outputText);
        mConvertButton = (Button) findViewById(R.id.calcButton);

        mConvertButton.setOnClickListener(new View.OnClickListener() {

            String currentFah;
            String convertedTemp;
            String currentCel;
            String currentKel;

            @Override
            public void onClick(View view) {

                if (!mFah.getText().toString().equals("")) {
                    currentFah = mFah.getText().toString();
                    float fahValue = Float.parseFloat(currentFah);

                    fahValue = fahValue - 32;
                    fahValue = fahValue / 9;
                    fahValue = fahValue * 5;

                    convertedTemp = String.valueOf(fahValue);

                    mOutputTextView.setText(currentFah + " Fahrenheit is " + convertedTemp + " Celsius");

                    fahValue = Float.parseFloat(currentFah);
                    fahValue = fahValue + 460;
                    fahValue = fahValue * 5;
                    fahValue = fahValue / 9;

                    convertedTemp = String.valueOf(fahValue);
                    mOutputTextView.append(" or " + convertedTemp + " Kelvin");

                    mFah.setText("");



                } else if (!mCel.getText().toString().equals("")) {
                    currentCel = mCel.getText().toString();
                    float celValue = Float.parseFloat(currentCel);

                    celValue = celValue * 9;
                    celValue = celValue / 5;
                    celValue = celValue + 32;

                    convertedTemp = String.valueOf(celValue);

                    mOutputTextView.setText(currentCel + " Celsius is " + convertedTemp + " Fahrenheit.");

                    celValue = Float.parseFloat(currentCel);
                    celValue = celValue * 273;

                    convertedTemp = String.valueOf(celValue);
                    mOutputTextView.append(" or " + convertedTemp + " Kelvin");

                    mCel.setText("");


                }  else if (!mKel.getText().toString().equals("")) {
                    currentKel = mKel.getText().toString();
                    float kelValue = Float.parseFloat(currentKel);

                    kelValue = kelValue * 9;
                    kelValue = kelValue / 5;
                    kelValue = kelValue - 460;

                    convertedTemp = String.valueOf(kelValue);

                    mOutputTextView.setText(currentKel + " Kelvin is " + convertedTemp + " Fahrenheit");

                    kelValue = Float.parseFloat(currentKel);
                    kelValue = kelValue * -273;

                    convertedTemp = String.valueOf(kelValue);

                    mOutputTextView.append("\n or " + convertedTemp + " Celsius");
                    mKel.setText("");
                }
            }
        });



        float fah = 86;
        System.out.println(fah + " degrees Fahrenheit is ...");
        // To convert Fahrenheit to Celsius, - 32 / 9 * 5
        // begin by subtracting 32
        fah = fah - 32;
        // Divide the answer by 9
        fah = fah / 9;
        // Multiply the answer by 5
        fah = fah * 5;
        System.out.println(fah + " degrees Celsius\n");

        float cel = 33;
        System.out.println(cel + " degrees Celsius is...");
        // To convert Celsius to Fahrenheit * 9 / 5 + 32
        // begin by multiplying by 9
        cel = cel * 9;
        // Divide the answer by 5
        cel = cel / 5;
        // Add 32 to the answer
        cel = cel + 32;
        System.out.println(cel + "degrees Fahrenheit\n");

        float kel = 56;
        System.out.println(kel + " degrees Kelvin is...");
        // To convert Kelvin to Fahrenheit * 9 / 5 - 460
        // begin by multiplying by 9
        kel = kel * 9;
        // Divide the answer by 5
        kel = kel / 5;
        // Minus 460
        kel = kel - 460;
        System.out.println(kel + " degrees Fahrenheit\n");


    }
}
