package com.raywenderlich.reposearch;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
    @GET("/repositories")
    Call<ArrayList<Repository>> retrieveRepositories();
}
