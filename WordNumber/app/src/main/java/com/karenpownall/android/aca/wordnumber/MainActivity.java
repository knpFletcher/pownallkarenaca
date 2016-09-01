package com.karenpownall.android.aca.wordnumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mConvertButton;
    private TextView mEditText;
    private TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultText = (TextView) findViewById(R.id.resultText);
        mConvertButton = (Button) findViewById(R.id.convertButton);
        mEditText = (TextView) findViewById(R.id.editText);

        mConvertButton.setOnClickListener(new View.OnClickListener() {
            //use switch statement for conversion (take words, make numbers)

            char charOne;
            char charTwo;
            long longNumber;

            @Override
            public void onClick(View view) {
                charOne = mEditText.getText().toString().toLowerCase().charAt(0);
                charTwo = mEditText.getText().toString().toLowerCase().charAt(1);
                //charOne = mEditText.getText().charAt(0);
                // also valid, but will run into capitalization issues
                //have to use .toString() to use .toLowerCase()
                //controls caps

                switch (charOne){
                    case 'o':
                        longNumber = 1L;
                        break;
                    case 'e':
                        longNumber = 8L;
                        break;
                    case 'n':
                        longNumber = 9L;
                        break;
                    case 'f':
                        if (charTwo == 'o') {
                            longNumber = 4L;
                            break;
                        } else if (charTwo == 'i'){
                            longNumber = 5L;
                            break;
                        }
                    case 's':
                        if (charTwo == 'i'){
                            longNumber = 6L;
                            break;
                        } else if (charTwo == 'e'){
                            longNumber = 7L;
                            break;
                        }
                    case 't':
                        if (charTwo == 'w'){
                            longNumber = 2L;
                            break;
                        } else if (charTwo == 'h'){
                            longNumber = 3L;
                            break;
                        } else if (charTwo == 'e'){
                            longNumber = 10L;
                            break;
                        }
                }
                mResultText.setText("The number is: " + longNumber);
            }

        });
    }
}
