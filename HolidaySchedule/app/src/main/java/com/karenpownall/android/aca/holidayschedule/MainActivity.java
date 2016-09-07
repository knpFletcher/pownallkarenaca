package com.karenpownall.android.aca.holidayschedule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.BitSet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HolidaySchedule cal = new HolidaySchedule(); //creates HolidaySchedule,
        // calls constructor, creates BitSet, adds holidays to it
        String day = "2";

        if (!day.equals("")) { //if day doesn't equal empty string
            try {
                int whichDay = Integer.parseInt(day); //convert string to int
                if (cal.isHoliday(whichDay)) { //pass day in
                    System.out.println("Day number " + whichDay +
                            " is a holiday!");
                } else {
                    System.out.println("Day number " + whichDay +
                            " is not a holiday.");
                }
            } catch (NumberFormatException nfe) { //if don't get number value, returns error message
                System.out.println("Error: " + nfe.getMessage());
            }
        }
    }
    //use a bit set to keep track of which days in the year are holidays
    public class HolidaySchedule { //start with class
        BitSet sked;
        public HolidaySchedule() { //need constructor
            sked = new BitSet(365);
            int [] holiday = { 1, 15, 50, 148, 185, 246,
                281, 316, 326, 359 }; //make int array storing number value of day, added to BitSet

            for (int i = 0; i < holiday.length; i++) {
                addHoliday(holiday[i]);
            }
        }
        //outside constructor/HolidaySchedule method, add method
        public void addHoliday(int dayToAdd){
            sked.set(dayToAdd);
        }
        public boolean isHoliday(int dayToCheck) { //need another method to check day
            return sked.get(dayToCheck);
        }
    }
}
