package com.karenpownall.android.aca.pong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textTitle = (TextView) findViewById(R.id.titleText);
        Button btnPlay = (Button) findViewById(R.id.btnPlay);
    }
}
