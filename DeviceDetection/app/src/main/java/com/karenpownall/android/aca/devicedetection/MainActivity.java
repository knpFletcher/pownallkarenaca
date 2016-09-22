package com.karenpownall.android.aca.devicedetection;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtOrientation;
    private TextView txtResolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get a reference to our TextView widgets
        txtOrientation = (TextView) findViewById(R.id.txtOrientation);
        txtResolution = (TextView) findViewById(R.id.txtResolution);
    } //end of OnCreate

    public void detectDevice(View v){
        //what is the orientation?
        Display display = getWindowManager().getDefaultDisplay();
        txtOrientation.setText("" + display.getRotation());

        //what is the resolution?
        Point xy = new Point();
        display.getSize(xy);
        txtResolution.setText("x = " + xy.x + " y = " + xy.y);
    } //end of detectDevice

} //end of MainActivity
