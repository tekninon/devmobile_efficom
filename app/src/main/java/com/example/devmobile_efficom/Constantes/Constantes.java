package com.example.devmobile_efficom.Constantes;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Constantes {

    //Cle api
    public final static String API_KEY = "f57df3003d1cee727235559efc58a4e3";

    //url api
    public final static String API_URL = "http://api.themoviedb.org/3/";

    //addon api language
    public final static String API_LANGUAGE = "fr";

    //Check up network is available
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

}
