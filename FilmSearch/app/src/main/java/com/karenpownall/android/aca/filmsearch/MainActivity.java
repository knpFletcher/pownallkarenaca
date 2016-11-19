package com.karenpownall.android.aca.filmsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.fab) FloatingActionButton fab;

    private MoviesAdapter mMoviesAdapter;

    Call<Movie.MovieResult> mCall;

    Retrofit restAdapter = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.themoviedb.org/")
            .build();

    MoviesApiService apiService = restAdapter.create(MoviesApiService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogSearch dialogSearch = new DialogSearch();
                dialogSearch.show(getFragmentManager(), "123");
            }
        });

        setRecyclerView();
        mCall = apiService.getPopularMovies();
        callMovieResult();

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {

                @Override public void onItemClick(View view, int position) {

                    Intent mDetailIntent = new Intent (getApplicationContext(), DetailActivity.class);
                    mDetailIntent.putExtra("Movie", mMoviesAdapter.getMovieList().get(position));
                    //.getMovieList built into adapter, get built into ArrayList
                    startActivity(mDetailIntent);
                }

                @Override
                public void onLongItemClick(View view, int position) {

                    //TODO make favorites functionality here instead

                    Intent mFavoritesIntent = new Intent (getApplicationContext(), DetailActivity.class);

                    mFavoritesIntent.putExtra("Movie", String.valueOf(mMoviesAdapter));
                    startActivity(mFavoritesIntent);

                }
            })
        );
    } //end onCreate

    private void callMovieResult() {
        mCall.enqueue(new Callback<Movie.MovieResult>() {

            @Override
            public void onResponse(Call<Movie.MovieResult> call, Response<Movie.MovieResult> response) {
                mMoviesAdapter.setMovieList(response.body().getResults());
            }

            @Override
            public void onFailure(Call<Movie.MovieResult> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void setRecyclerView() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mMoviesAdapter = new MoviesAdapter(this);
        mRecyclerView.setAdapter(mMoviesAdapter); //set adapter to recycler view
        List<Movie> movies = new ArrayList<>();

        for (int i = 0; i < 26; i++){
            movies.add(new Movie());
        }
        mMoviesAdapter.setMovieList(movies);  //pass in movie list ArrayList

    } //end setRecyclerView

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    } //end onCreateOptionsMenu

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
    } //end OnOptionsItemSelected

    @Override
    protected void onResume() {

        String mSearch;
                try{Intent mSearchIntent = getIntent();

                    if (mSearchIntent.getStringExtra("Search") != null) {

                        mSearch = mSearchIntent.getStringExtra("Search");
                        mCall = apiService.getSearchedMovies(mSearch);
                        setRecyclerView();
                        callMovieResult();
                    } else{
                        mCall = apiService.getPopularMovies();
                        setRecyclerView();
                        callMovieResult();

                    }

                } catch(NullPointerException nullObject) {
                        mCall = apiService.getPopularMovies();
                        setRecyclerView();
                        callMovieResult();
                }

        super.onResume();

    } //end onResume

} //end MainActivity
