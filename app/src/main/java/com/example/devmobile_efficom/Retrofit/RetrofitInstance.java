package com.example.devmobile_efficom.Retrofit;

import com.example.devmobile_efficom.Constantes.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Evert Moreno on 24-01-2018.
 */
public class RetrofitInstance {

    private static Retrofit retrofit = null;


    /**
     * Gets client.
     *
     * @return the client
     */
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constantes.API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}