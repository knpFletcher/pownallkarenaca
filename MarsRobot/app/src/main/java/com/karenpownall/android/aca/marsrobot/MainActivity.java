package com.karenpownall.android.aca.marsrobot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MarsRobot spirit = new MarsRobot();
        spirit.status = "exploring";
        spirit.speed = 2;
        spirit.temperature = -60;

        spirit.showAttributes();
        System.out.println("Increasing speed to 3.");
        spirit.speed = 3;
        spirit.showAttributes();
        System.out.println("Changing temperature to -90.");
        spirit.temperature = -90;
        System.out.println("Checking the temperature.");
        spirit.checkTemperature();
        spirit.showAttributes();

        MarsRobot joy = new MarsRobot();
        joy.sol = 48;
        joy.power = 100;


        joy.showAttributes();
        System.out.println("Checking solar date.");
        joy.sol = 48;
        joy.showAttributes();
        System.out.println("Checking power.");
        joy.power = 20;
        joy.checkRobot();
        joy.showAttributes();

    }
}
