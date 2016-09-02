package com.karenpownall.android.aca.primefinder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //PrimeFinder mPrimeFinder;
    private Button mFindButton;
    private TextView mEditNumber;
    public TextView mPrimeFound;
    PrimeFinder mPrimefinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEditNumber = (TextView) findViewById(R.id.editNumber);
        mFindButton = (Button) findViewById(R.id.findButton);
        mPrimeFound = (TextView) findViewById(R.id.primeFound);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long argument;
                argument = Long.parseLong(mEditNumber.getText().toString());
                mPrimefinder = new PrimeFinder(argument, mPrimeFound);
            }
        });

        //mPrimeFinder = new PrimeFinder(100);

        /* mFindButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){


            }
        }); */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // intercept click on options in menu
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
