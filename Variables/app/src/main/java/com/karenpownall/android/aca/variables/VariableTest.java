package com.karenpownall.android.aca.variables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VariableTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable_test);

        int someNumber = 14828574;
        boolean q = true;
        String primitiveTypes = "There are 8 primitive types!";
        float decimalNumber = 6.5f;
        long lastNumber = 1000000000;
        byte aNumber = 83;
        char j = '&';
        short anotherNumber = 32500;
        double preciseNumber = 19.85;

        System.out.println("Population of Zimbabwe: " + someNumber);
        System.out.println("Star Wars is amazing:" + q);
        System.out.println("How many primitive types are there? " + primitiveTypes);
        System.out.println("Use " + decimalNumber + "apples for the pie.");
        System.out.println("The global ant population exceeds " + lastNumber);
        System.out.println("The atomic number of Bismuth is " + aNumber);
        System.out.println("This and symbol " + j + "is called an ampersand.");
        System.out.println("Liechtenstein's population, " + anotherNumber + ", is the smallest of any country.");
        System.out.println("An example of a double primitive type is " + preciseNumber);
    }
}
