package com.karenpownall.android.aca.magicball;

import java.util.Random;

public class Dice {
    /* private int [] mDice = {
            1, 2, 3, 4, 5, 6
    }; */
    //figured out it doesn't even need an array!

    public String getDice(){
        String diceText;
        int dice;

        //2 random number generators
        Random randomGeneratorOne = new Random();
        int randomNumber = randomGeneratorOne.nextInt(7);

        Random randomGeneratorTwo = new Random();
        int randomNumberTwo = randomGeneratorTwo.nextInt(7);

        //add together
        dice = randomNumber + randomNumberTwo;
        diceText = Integer.toString(dice);

        return diceText;
    }
}
