package com.karenpownall.android.aca.marsrobot;

import java.util.Date;

/**
 * Created by kkpwnall on 8/24/16.
 */
public class MarsRobot {
    String status;
    int speed;
    float temperature;
    int sol;
    int power;

    void checkTemperature() {
        if (temperature < -80) {
            status = "returning home";
            speed = 5;

        }
    }

    void checkRobot() {
        if (sol == 686 || power < 30) {
            status = "returning home";
            speed = 5;
        }
    }

    void showAttributes() {
        System.out.println("Status: " + status);
        System.out.println("Speed: " + speed);
        System.out.println("Temperature: " + temperature);
        System.out.println("Solar Day" + sol);
        System.out.println("Battery power" + power);
    }


}
