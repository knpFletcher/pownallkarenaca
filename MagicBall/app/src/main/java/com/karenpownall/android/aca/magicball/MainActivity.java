package com.karenpownall.android.aca.magicball;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Messages mMessages = new Messages();
    public TextView mMagicText;
    public Dice mDiceText = new Dice();
    //why does this line throw errors?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        mMagicText = (TextView) findViewById(R.id.magicText);
        //throwing to the same textView

        //magic 8 ball button
        FloatingActionButton magicButton = (FloatingActionButton) findViewById(R.id.magicButton);
        magicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                        */
                String message = mMessages.getMessage();
                mMagicText.setText(message);
            }
        });

        //dice button
        FloatingActionButton diceButton = (FloatingActionButton) findViewById(R.id.diceButton);
        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diceText = mDiceText.getDice();
                mMagicText.setText(diceText);
            }
        });

    }

    /* Simplifying
    Don't think I need this for this app

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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
