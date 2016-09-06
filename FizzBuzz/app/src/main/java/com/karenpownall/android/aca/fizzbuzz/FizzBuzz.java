package com.karenpownall.android.aca.fizzbuzz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FizzBuzz extends AppCompatActivity {

    private Button mConvertButton;
    private TextView mEditNumber;
    private TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fizz_buzz);

        mResultText = (TextView) findViewById(R.id.resultText);
        mConvertButton = (Button) findViewById(R.id.convertButton);
        mEditNumber = (TextView) findViewById(R.id.editNumber);

        mConvertButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                int i = Integer.parseInt(mEditNumber.getText().toString());

                if ((i % 3) == 0 && (i % 5) == 0){
                    mResultText.setText("FizzBuzz");
                } else if (i % 3 == 0) {
                    mResultText.setText("Fizz");
                } else if (i % 5 == 0) {
                    mResultText.setText("Buzz");
                } else mResultText.setText("Neither Fizz nor Buzz");
            }

        });

    }
}