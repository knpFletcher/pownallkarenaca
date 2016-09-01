package com.karenpownall.android.aca.wordnumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mConvertButton;
    TextView mEditText;
    TextView mResultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultText = (TextView) findViewById(R.id.resultText);
        mConvertButton = (Button) findViewById(R.id.convertButton);
        mEditText = (TextView) findViewById(R.id.editText);

        //char firstChar = mEditText.getText().toString.charAt(0);
       // char secondChar= mEditText.getText().toString.charAt(1);


        mConvertButton.setOnClickListener(new View.OnClickListener() {
            //use switch statement for conversion (take words, make numbers)

            char charOne;
            char charTwo;
            long longNumber;

            @Override
            public void onClick(View view) {
                charOne = mEditText.getText().charAt(0);
                charTwo = mEditText.getText().charAt(1);

                switch (charOne){
                    case 'O':
                        longNumber = 1L;
                        mResultText.setText(String.valueOf(longNumber));
                        break;
                    case 'E':
                        longNumber = 8L;
                        mResultText.setText(String.valueOf(longNumber));
                        break;
                    case 'N':
                        longNumber = 9L;
                        mResultText.setText(String.valueOf(longNumber));
                        break;
                    case 'F':
                        if (charTwo == 'O') {
                            longNumber = 4L;
                            mResultText.setText(String.valueOf(longNumber));
                            break;
                        } else if (charTwo == 'I'){
                            longNumber = 5L;
                            mResultText.setText(String.valueOf(longNumber));
                            break;
                        }
                    case 'S':
                        if (charTwo == 'I'){
                            longNumber = 6L;
                            mResultText.setText(String.valueOf(longNumber));
                            break;
                        } else if (charTwo == 'E'){
                            longNumber = 7L;
                            mResultText.setText(String.valueOf(longNumber));
                            break;
                        }
                    case 'T':
                        if (charTwo == 'W'){
                            longNumber = 2L;
                            mResultText.setText(String.valueOf(longNumber));
                            break;
                        } else if (charTwo == 'H'){
                            longNumber = 3L;
                            mResultText.setText(String.valueOf(longNumber));
                            break;
                        } else if (charTwo == 'E'){
                            longNumber = 10L;
                            mResultText.setText(String.valueOf(longNumber));
                            break;
                        }
                }
                //mResultText.setText
            }

        });
    }
}
