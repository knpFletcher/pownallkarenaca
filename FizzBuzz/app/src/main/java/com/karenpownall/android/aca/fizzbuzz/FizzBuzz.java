package com.karenpownall.android.aca.fizzbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FizzBuzz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fizz_buzz);

        for (int i = 1; i <= 15; i++) {
            if ((i % 3) == 0 && (i % 5) == 0){
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}