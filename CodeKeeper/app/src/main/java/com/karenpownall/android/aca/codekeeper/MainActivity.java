//feed an array list, some provided by user
//because size isn't known, use ArrrayList

//string input from user, add to list
package com.karenpownall.android.aca.codekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private Button mAddButton;
    private EditText mUserInput;
    private TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

               /* String[] userStrings = {"omega", "beta", "omicron"};
               CodeKeeper keeper = new CodeKeeper(userStrings); */
        mUserInput = (EditText) findViewById(R.id.userInput);
        mResultText = (TextView) findViewById(R.id.resultText);
        mAddButton = (Button) findViewById(R.id.addButton);

        final String[] userStrings = new String[10];

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userCode;

                if (mUserInput.getText().toString() != "") {
                    userCode = mUserInput.getText().toString();
                    userStrings [0] = userCode;
                }
                CodeKeeper keeper = new CodeKeeper(userStrings);
            }
        });

    }

    public class CodeKeeper { //add new instance class
        ArrayList list;
        String[] codes = {"alpha", "lambda", "gamma", "delta", "zeta"}; //string array

        public CodeKeeper(String[] userCodes) {
            list = new ArrayList(); //initialize array list
            //load built-in codes
            for (int i = 0; i < codes.length; i++) {
                addCode(codes[i]); //every time it loops through, calls addCode method
            }
            //load user codes
            for (int j = 0; j < userCodes.length; j++) {
                addCode(userCodes[j]);
            }
            //display all codes
            for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
                String output = (String) iterator.next();
                System.out.println(output);
                mResultText.append(output + "\n");
            }
        }

        private void addCode(String code) { //pass in String when looping through array
            if (!list.contains(code)) { //if list doesn't contain the code,
                //add it
                list.add(code);
            }
        }
    }
}
