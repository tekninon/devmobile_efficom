package com.example.devmobile_efficom.ui.movies;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.devmobile_efficom.Adapter.MovieAdapter;
import com.example.devmobile_efficom.Constantes.Constantes;
import com.example.devmobile_efficom.R;
import com.example.devmobile_efficom.Retrofit.RetrofitInstance;
import com.example.devmobile_efficom.Services.MovieDataService;
import com.example.devmobile_efficom.models.Movie;
import com.example.devmobile_efficom.models.MoviesResponse;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieFragment extends Fragment {

    private MovieViewModel movieViewModel;
    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private List<Movie> movieList;
    private SQLite dbHelper;
    ProgressDialog pd;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


       /* movieViewModel =
                ViewModelProviders.of(this).get(MovieViewModel.class);
        View root = inflater.inflate(R.layout.fragment_movies, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        movieViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;*/
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_movies);


        return null;
    }

    private void loadData() {
        try {
            if (Constantes.API_KEY.isEmpty()) {
                Toast.makeText(getActivity(), "Please get a Key for TMBD API, on themoviedb.org", Toast.LENGTH_SHORT).show();
                pd.dismiss();
                return;
            }
            if (Constantes.isNetworkAvailable(getContext())) {
                RetrofitInstance Instance = new RetrofitInstance();
                MovieDataService apiService = Instance.getClient().create(MovieDataService.class);
                Call<MoviesResponse> call = apiService.getPopularMovies(Constantes.API_KEY, Constantes.API_LANGUAGE);
                call.enqueue(new Callback<MoviesResponse>() {
                    @Override
                    public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                        List<Movie> movies = response.body().getMovies();
                        Collections.sort(movies, Movie.BY_NAME_ALPHABETICAL);
                        recyclerView.setAdapter(new MovieAdapter(movies, getActivity()));
                        recyclerView.smoothScrollToPosition(0);
                    }

                    @Override
                    public void onFailure(Call<MoviesResponse> call, Throwable t) {
                        Log.d("Error", t.getMessage());
                        getAllMovies();
                    }
                });
            } else {
                getAllMovies();
            }
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("StaticFieldLeak")
    private void getAllMovies() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                movieList.clear();
                movieList.addAll(dbHelper.getAllMovies());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
