package com.karenpownall.android.aca.daycounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.karenpownall.android.aca.daycounter.utils.DayCounter;

public class MainActivity extends AppCompatActivity {

    DayCounter mDayCounter;
    //separate control from view

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDayCounter = new DayCounter();

        int yearIn = 2016;
        int monthIn;
        int dayIn;

        /*System.out.println(monthIn + "/" + yearIn + " has "
                + countDays(monthIn, yearIn) + " days."); */

        //nested for loop here (2), new System.out.print inside for loop; countDays method as inst variable
        for (monthIn = 1; monthIn < 13; monthIn++){
            for (dayIn = 1; dayIn <= mDayCounter.countDays(monthIn, yearIn); dayIn++){
                //day less than equal to return value of countDays method, prints line
                System.out.println(monthIn + "/" + dayIn + "/" + yearIn);
            }
        }
    }
}
