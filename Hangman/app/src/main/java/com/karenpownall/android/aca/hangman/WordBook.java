package com.karenpownall.android.aca.hangman;

import java.util.Random;

public class WordBook {
    //string array to hold words, chosen at random for the user

    private String[] mWords = {
        "june"
    };

    public String getWord(){
        String word;
        //randomly select a word from the string array
        Random randomGenerator = new Random();
        int randomWord = randomGenerator.nextInt(mWords.length);
        word = mWords[randomWord];

        return word;
    }
}
