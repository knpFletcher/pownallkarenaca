package com.karenpownall.android.aca.filmsearch;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApiService {

    @GET("/3/movie/popular?api_key=6b7579445faf46d6b108204543118376")
    Call<Movie.MovieResult> getPopularMovies();

    //search call query goes here
    @GET("3/search/multi?api_key=6b7579445faf46d6b108204543118376")
    Call<Movie.MovieResult> searchMovies();
}
