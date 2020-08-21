package com.example.devmobile_efficom.api;

import com.example.devmobile_efficom.models.MovieResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetMovieService {

    //cle api : f57df3003d1cee727235559efc58a4e3
    @GET("movie/moviesHome")
    Call<MovieResult> getMoviesHome(@Query("page") int page, @Query("api_key") String apiKey);
}
