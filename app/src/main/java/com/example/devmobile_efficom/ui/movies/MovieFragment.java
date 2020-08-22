package com.example.devmobile_efficom.ui.movies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.devmobile_efficom.R;

public class MovieFragment extends Fragment {

    private MovieViewModel movieViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        movieViewModel =
                ViewModelProviders.of(this).get(MovieViewModel.class);
        View root = inflater.inflate(R.layout.fragment_movies, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        movieViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
