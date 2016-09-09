//Maps for shopping app
//use conditions, associate values with numeric value (floating point number)

package com.karenpownall.android.aca.comicbooks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button mComixButton;
    private TextView mOutputText;
    private EditText mBasePrice;
    private EditText mConditionText;
    private EditText mIssueText;
    private EditText mTitleText;
    public HashMap quality = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOutputText = (TextView) findViewById(R.id.outputText);
        mBasePrice = (EditText) findViewById(R.id.basePrice);
        mConditionText = (EditText) findViewById(R.id.conditionText);
        mIssueText = (EditText) findViewById(R.id.issueText);
        mTitleText = (EditText) findViewById(R.id.titleText);
        mComixButton = (Button) findViewById(R.id.comixButton);


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
        final Comic[] comix = new Comic[4];
        //add comics to collection
        comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine", 12_000.00f);
        //passing in title, issue number, condition, base price
        comix[0].setPrice((Float) quality.get(comix[0].condition)); //call method, cast to float

        comix[1] = new Comic("Incredible Hulk", "181", "near mint", 680.00f);
        comix[1].setPrice((Float) quality.get(comix[1].condition));

        comix[2] = new Comic("Cerebus", "1A", "good", 190.00f);
        comix[2].setPrice((Float) quality.get(comix[2].condition));

        mComixButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
            String title;
            String issue;
            String condition;
            float basePrice;

            //Comic userComic = new Comic;

            title = mTitleText.getText().toString();
            issue = mIssueText.getText().toString();
            condition = mConditionText.getText().toString();
            basePrice = Float.parseFloat(mBasePrice.getText().toString());

            comix[3] = new Comic(title, issue, condition, basePrice);
            comix[3].setPrice((Float) quality.get(comix[3].condition));

            for (int i = 0; i < comix.length; i++) {
                System.out.println("Title: " + comix[i].title);
                System.out.println("Issue: " + comix[i].issueNumber);
                System.out.println("Condition: " + comix[i].condition);
                System.out.println("Price: $" + comix[i].price + "\n");
                mOutputText.setText("Price: $" + comix[i].price);
            }

            }
        });
    }

    public class Comic {
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
