package com.karenpownall.android.aca.javameetui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {   //a new way to add onClick

    //an int variable to hold a value
    int value = 0;
    private Button btnAdd;
    private Button btnTake;
    private Button btnGrow;
    private Button btnShrink;
    private Button btnReset;
    private Button btnHide;
    private TextView txtValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get a reference to all the buttons in our UI
        //Match them up to all our button objects declared earlier
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnTake = (Button) findViewById(R.id.btnTake);
        btnGrow = (Button) findViewById(R.id.btnGrow);
        btnHide = (Button) findViewById(R.id.btnHide);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnShrink = (Button) findViewById(R.id.btnShrink);
        txtValue = (TextView) findViewById(R.id.txtValue);

        //Listen for all the button clicks
        btnAdd.setOnClickListener(this);
        btnTake.setOnClickListener(this);
        btnGrow.setOnClickListener(this);
        btnHide.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnShrink.setOnClickListener(this);
        txtValue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //A local variable to use later
        float size;
        switch(v.getId()){
            case R.id.btnAdd:
                value++;
                txtValue.setText("" + value);
                break;
            case R.id.btnTake:
                value--;
                txtValue.setText("" + value);
                break;
            case R.id.btnReset:
                value = 0;
                txtValue.setText("" + value);
                break;
            case R.id.btnGrow:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size + 1);
                break;
            case R.id.btnShrink:
                size = txtValue.getTextScaleX();
                txtValue.setTextScaleX(size-1);
                break;
            case R.id.btnHide:
                if(txtValue.getVisibility() == View.VISIBLE) {
                    //currently visible so hide it
                    txtValue.setVisibility(View.INVISIBLE);
                    //change text on the button
                    btnHide.setText("SHOW");
                } else {
                    //currently hidden so show it
                    txtValue.setVisibility(View.VISIBLE);
                    //change text on the button
                    btnHide.setText("HIDE");
                }
                break;

        }
    }
}
