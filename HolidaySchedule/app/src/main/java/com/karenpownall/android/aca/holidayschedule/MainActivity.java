package com.karenpownall.android.aca.holidayschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.BitSet;

public class MainActivity extends AppCompatActivity {
    public EditText mMonthText;
    public EditText mDateText;
    public TextView mHolidayView;
    public Button mHolidayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHolidayButton = (Button) findViewById(R.id.holidayButton);
        mMonthText = (EditText) findViewById(R.id.monthText);
        mDateText = (EditText) findViewById(R.id.dateText);
        mHolidayView = (TextView) findViewById(R.id.holidayView);

        mHolidayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int month = Integer.parseInt(mMonthText.getText().toString());
                int date = Integer.parseInt(mDateText.getText().toString());
                mHolidayView.setText(Month(month) + date + "");


                HolidaySchedule cal = new HolidaySchedule();
                if (cal.isHoliday(Month(month) + date)) {
                    mHolidayView.setText("YES! It is a holiday! Go out and play!");
                } else if (!cal.isHoliday(Month(month) + date)){
                    mHolidayView.setText("No... it's not a holiday. Get back to work!");
                }
            }

        });
        //HolidaySchedule cal = new HolidaySchedule(); //creates HolidaySchedule,
        // calls constructor, creates BitSet, adds holidays to it
        /* String day = "2";

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
        } */
    }


    private int Month(int month) {
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
                count = 28;
                break;
            }
        return count;

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
