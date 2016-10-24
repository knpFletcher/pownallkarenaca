package com.karenpownall.android.aca.filmsearch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private TextView titleText;
    private TextView descriptionText;
    private ImageView backdropImage;

    public Movie mMovie = new Movie();
    Context mContext;

    public DetailActivity(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        titleText = (TextView) findViewById(R.id.titleText);
        descriptionText = (TextView) findViewById(R.id.descriptionText);
        backdropImage = (ImageView) findViewById(R.id.backdropImage);

        //put data from intent into movie class
        Intent mIntent = getIntent();
        mIntent.getSerializableExtra("Movie");

        //set equal to data pulled down
        Movie mMovie = (Movie) mIntent.getSerializableExtra("Movie");

        //use movie object to call methods - chain methods
        titleText.setText(mMovie.getMovieTitle());
        descriptionText.setText(mMovie.getDescription());

        Picasso.with(mContext)
                .load(mMovie.getBackdrop())
                .placeholder(R.color.colorAccent)
                .into(backdropImage);
    }


}


//pass data from Movies adapter using extra
//needs intent with extra with data passing
//search passing object to activity