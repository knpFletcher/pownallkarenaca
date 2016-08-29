package com.karenpownall.android.aca.birthday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mNumMonth;
    TextView mNumDate;
    TextView mNumYear;
    TextView mNumHeight;
    TextView mNumWeight;
    TextView mNumDepth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumMonth = (TextView) findViewById(R.id.numMonth);
        mNumDate = (TextView) findViewById(R.id.numDate);
        mNumYear = (TextView)  findViewById(R.id.numYear);
        mNumHeight = (TextView) findViewById(R.id.numHeight);
        mNumHeight.setText("9");
        mNumWeight = (TextView) findViewById(R.id.numWeight);
        mNumWeight.setText("6");
        mNumDepth = (TextView) findViewById(R.id.numDepth);
        mNumDepth.setText("14");


        String  birthday = new String ("04/29/2016");
        mNumMonth.setText("04");
        System.out.print("Month: " );
        System.out.println(birthday.substring(0, 2) );

        mNumDate.setText("29");
        System.out.print("Day: ");
        System.out.println(birthday.substring(3, 5) );

        mNumYear.setText("2016");
        System.out.println("Year: " + birthday.substring(6));

        Cake iceCream = new Cake();
        iceCream.height = 9;
        iceCream.weight = 6;
        iceCream.depth = 14;
        iceCream.showAttributes();

    }
}
