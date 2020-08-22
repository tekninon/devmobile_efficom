package com.example.devmobile_efficom.Services;

import com.example.devmobile_efficom.models.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Service qui va permettre de recuperer les donnees de l'api
 */
public interface MovieDataService {

    @GET("movie/popular")
    Call<MoviesResponse> getPopularMovies(@Query("api_key") String apiKey);


}