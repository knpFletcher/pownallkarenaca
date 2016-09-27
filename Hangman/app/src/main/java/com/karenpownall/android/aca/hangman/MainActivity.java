package com.karenpownall.android.aca.hangman;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private EditText mLetterText;
    //private EditText mEditText2;
    //private EditText mEditText3;
    //private EditText mEditText4;
    private TextView mWrongLetters;
    private TextView mRightLetters;
    private Button mBtnGuess;
    private WordBook mWordbook = new WordBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLetterText = (EditText) findViewById(R.id.letterText);
        //mEditText2 = (EditText) findViewById(R.id.editText2);
        //mEditText3 = (EditText) findViewById(R.id.editText3);
        //mEditText4 = (EditText) findViewById(R.id.editText4);
        mWrongLetters = (TextView) findViewById(R.id.wrongLetters);
        mRightLetters = (TextView) findViewById(R.id.rightLetters);
        mBtnGuess = (Button) findViewById(R.id.btnGuess);

        //choose word when app is created, before guess button is clicked
        String word = mWordbook.getWord();
        final String[] userLetters = new String[26];

        mBtnGuess.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //get letter from EditText1, compare it to each letter in word
                String guessLetter;

                //need to compare 1st, then add to wrongLetter TV

                

                if (mLetterText.getText().toString() != "") {
                    guessLetter = mLetterText.getText().toString();
                    userLetters [0] = guessLetter;
                }
                Letter guessedLetter = new Letter(userLetters); //call Letter class
            }
        }); //end of onClick

    } //end of OnCreate

    //borrowed from CodeKeeper to add wrong letters to WrongLetter TextView
    public class Letter { //add new instance class
        ArrayList list;
        String[] letter; //string array, use empty because no letters have been guessed?

        public Letter(String[] userLetter) {
            list = new ArrayList(); //initialize array list

            for (int i = 0; i < letter.length; i++) {
                addLetter(letter[i]); //every time it loops through, calls addLetter method
            }
            for (int j = 0; j < userLetter.length; j++) {
                addLetter(userLetter[j]);
            }
            for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
                String output = (String) iterator.next();
                System.out.println(output);
                mWrongLetters.append(output + "\n");
            }
        }

        private void addLetter(String letter) { //pass in String when looping through array
            if (!list.contains(letter)) { //if list doesn't contain the letter,
                //add it
                list.add(letter);
            }
        }
    } //end of Hangman class

} //end of MainActivity





//if else, take user input and compare it to string array
//for () loop to iterate through length of word letter by letter

        /* use substring? how does this work for words of different length?
        iterate through word for .length?
        i++ for(x,y)?

        if (mEditText1.getText().equals(word.substring(0,1))) {
            mRightLetters.setText(word.substring(0,1));
        } else {
        }

        System.out.println(word.substring(0,1));
        System.out.println(word.substring(1,2));
        System.out.println(word.substring(2,3));
        System.out.println(word.substring(3));

        */