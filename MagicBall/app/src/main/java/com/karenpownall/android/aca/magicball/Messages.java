package com.karenpownall.android.aca.magicball;

import java.util.Random;

public class Messages {
    //Magic 8 ball messages, Yoda translation
    private String [] mMessages = {
        "Certain, it is certain.",
        "Decidedly, it is so.",
        "Without doubt.",
        "Yes, definitely.",
        "Rely on it, you may.",
        "As it, yes, I see it.",
        "Most likely.",
        "Outlook good.",
        "Yes, hmm.",
        "To yes, signs point.",
        "Hmm hazy try again.",
        "Ask again later.",
        "Better not now, tell you I won't.",
        "Predict now, cannot.",
        "Concentrate and ask again.",
        "Count on it, do not.",
        "No, my reply is.",
        "My sources say no.",
        "Outlook so good not.",
        "Very doubtful. Yes, hmmm.",
    };

    public String getMessage(){
        String message;
        //randomly select a message
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mMessages.length);
        message = mMessages[randomNumber];

        return message;
    }
}
