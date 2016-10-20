package com.karenpownall.android.aca.multiflavorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.karenpownall.android.aca.multiflavorapp.free.NewActivity;

// like if had 2 versions of app, paid vs free
//free has ad-support, paid doesn't
//build off free 1st, then in paid take out ad-support

public class MainActivity extends AppCompatActivity {

    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NewActivity.class));
                //declare intent and pass all in 1 line
            }
        });
    }
}