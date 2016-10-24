package com.karenpownall.android.aca.filmsearch;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
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


                /* toss back to MainActivity to handle search

                Call<Movie.MovieResult> call = apiService.getSearchedMovies(mSearchText.getText().toString());
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

                */

            }
        });

        return builder.create();
    }
}
