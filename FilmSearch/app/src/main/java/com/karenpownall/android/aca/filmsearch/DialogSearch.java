package com.karenpownall.android.aca.filmsearch;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.karenpownall.android.aca.filmsearch.R.layout.dialog_search;

public class DialogSearch extends DialogFragment{

    @BindView(R.id.queryButton) Button mQueryButton;
    @BindView(R.id.searchText) EditText mSearchText;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.cancelButton) Button mCancelButton;

    private RecyclerView mRecyclerView;
    private MoviesAdapter mMoviesAdapter;

    Retrofit restAdapter = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://api.themoviedb.org/")
            .build();

    MoviesApiService apiService = restAdapter.create(MoviesApiService.class);

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        //View dialogView = inflater.inflate(R.layout.dialog_search, null);
        View view = LayoutInflater.from(getActivity()).inflate(dialog_search, null);

        ButterKnife.bind(this, view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setView(dialog_search).setMessage("Search");
        }

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        mQueryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSearchText.getText().toString();

                Call<Movie.MovieResult> call = apiService.searchMovies();
                call.enqueue(new Callback<Movie.MovieResult>() {

                    @Override
                    public void onResponse(Call<Movie.MovieResult> call, Response<Movie.MovieResult> response) {
                        mMoviesAdapter.setMovieList(response.body().getResults());
                    }

                    @Override
                    public void onFailure(Call<Movie.MovieResult> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

                Runnable runnable = new Runnable() {
                    public void run() {
                        runOnUiThread(new Runnable() {
                            public void run()
                            {
                                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                                mMoviesAdapter = new MoviesAdapter(this);
                                mRecyclerView.setAdapter(mMoviesAdapter); //set adapter to recycler view
                                List<Movie> movies = new ArrayList<>();

                                for (int i = 0; i < 26; i++){
                                    movies.add(new Movie());
                                }
                                mMoviesAdapter.setMovieList(movies);
                            }
                        });
                    }
                };

            }
        });

        return builder.create();
    }
}
