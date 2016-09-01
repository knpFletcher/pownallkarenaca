package com.karenpownall.android.aca.daycounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int yearIn = 2016;
        int monthIn;
        int dayIn;

        /*System.out.println(monthIn + "/" + yearIn + " has "
                + countDays(monthIn, yearIn) + " days."); */

        //nested for loop here (2), new System.out.print inside for loop; countDays method as inst variable
        for (monthIn = 1; monthIn < 13; monthIn++){
            //System.out.println(monthIn + "/" + yearIn + " has " + countDays(monthIn, yearIn) + " days.");
            for (dayIn = 1; dayIn <= countDays(monthIn, yearIn); dayIn++){ //day less than equal to countDays method, prints line
                System.out.println(monthIn + "/" + dayIn + "/" + yearIn);
            }
        }
    }

    private int countDays(int month, int year) {
        int count = -1;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;
            case 2:
                if (year % 4 == 0) {
                    count = 29;
                } else {
                    count = 28;
                }

                if ((year % 100 == 0) && (year % 400 != 0)) {
                    count = 28;
                }
        }
        return count;
    }

}
