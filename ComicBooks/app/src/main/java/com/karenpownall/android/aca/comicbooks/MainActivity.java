//Maps for shopping app
//use conditions, associate values with numeric value (floating point number)

package com.karenpownall.android.aca.comicbooks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up hash map
        HashMap quality = new HashMap(); //create

        float price1 = 3.00F; //add values
        quality.put("mint", price1); //key value pair
        float price2 = 2.00f;
        quality.put("near mint", price2);
        float price3 = 1.50f;
        quality.put("very fine", price3);
        float price4 = 1.00f;
        quality.put("fine", price4);
        float price5 = 0.50f;
        quality.put("good", price5);
        float price6 = 0.25f;
        quality.put("poor", price6);

        //set up a collection, create array based off Comic class
        Comic[] comix = new Comic[3];
        //add comics to collection
        comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine", 12_000.00f);
        //passing in title, issue number, condition, base price
        comix[0].setPrice((Float) quality.get(comix[0].condition)); //call method, cast to float

        comix[1] = new Comic("Incredible Hulk", "181", "near mint", 680.00f);
        comix[1].setPrice((Float) quality.get(comix[1].condition));

        comix[2] = new Comic("Cerebus", "1A", "good", 190.00f);
        comix[2].setPrice((Float) quality.get(comix[2].condition));

        for (int i = 0; i < comix.length; i++) {
            System.out.println("Title: " + comix[i].title);
            System.out.println("Issue: " + comix[i].issueNumber);
            System.out.println("Condition: " + comix[i].condition);
            System.out.println("Price: $" + comix[i].price + "\n");
        }

    }
    class Comic {
        String title;
        String issueNumber;
        String condition;
        float basePrice;
        float price;

        //constructor for Comic class
        Comic (String inTitle, String inIssueNumber, String inCondition, float inBasePrice){
            title = inTitle;
            issueNumber = inIssueNumber;
            condition = inCondition;
            basePrice = inBasePrice;
        }
        void setPrice(float factor){ //set price according to factor passed in
            price = basePrice * factor;
        }
    }
}
