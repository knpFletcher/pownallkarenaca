package com.karenpownall.android.aca.filmsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView titleText;
    private TextView descriptionText;
    private ImageView backgroundImage;

    public Movie mMovie = new Movie();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent mIntent = getIntent();
        mIntent.getSerializableExtra("Movie");

        /*
        mMovie.getTitle();
        mMovie.getBackdrop();
        mMovie.getDescription();
        */


        //put data from intent into movie class

        titleText = (TextView) findViewById(R.id.titleText);
        descriptionText = (TextView) findViewById(R.id.descriptionText);
        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);

        //pass data from Movies adapter using extra
        //needs intent with extra with data passing
        //search passing object to activity

        //use getter methods to set views
        titleText.setText(getTitle());
        //descriptionText.setText(getDescription());
        //backgroundImage.getBackdrop();


    }

}
