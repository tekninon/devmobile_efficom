package com.example.devmobile_efficom.Adapter;

import com.example.devmobile_efficom.R;
import com.example.devmobile_efficom.models.*;
import com.example.devmobile_efficom.ui.movies.DetailMovie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter  extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>   {

    private List<Movie> movieList;
    private Context context;

    public MovieAdapter( List<Movie> movieList, Context context){
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titre.setText(movieList.get(position).getOriginalTitle());
        String vote = Double.toString(movieList.get(position).getVoteAverage());
        holder.note.setText(vote);

        //url pour retrouver l'image correspondante au film donne
        String poster = "https://image.tmdb.org/t/p/w500" + movieList.get(position).getPosterPath();
    }

    @Override
    public int getItemCount() {
            return movieList.size();
    }


    public  class MyViewHolder extends RecyclerView.ViewHolder {

        //variables d'un card view
        public TextView titre, note;
        public ImageView afficheFilm;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            titre = (TextView) itemView.findViewById(R.id.title);
            note = (TextView) itemView.findViewById(R.id.userrating);
            afficheFilm = (ImageView) itemView.findViewById(R.id.thumbnail);


            //la creation de l'intent pour afficher les details d'un film
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        Movie clickedDataItem = movieList.get(pos);
                        Intent intent = new Intent(context, DetailMovie.class);
                        intent.putExtra("movies", clickedDataItem );
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);

                    }
                }
            });
        }


        }
    }

