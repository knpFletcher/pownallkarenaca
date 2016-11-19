package com.karenpownall.android.aca.filmsearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApiService {

    @GET("/3/movie/popular?api_key=6b7579445faf46d6b108204543118376")
    Call<Movie.MovieResult> getPopularMovies();

    //search call query goes here
    @GET("3/search/movie?api_key=6b7579445faf46d6b108204543118376&language=en-US")
    Call<Movie.MovieResult> getSearchedMovies(@Query("query") String q);
}
