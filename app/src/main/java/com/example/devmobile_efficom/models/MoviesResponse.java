package com.example.devmobile_efficom.models;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse implements Parcelable {

    @SerializedName("page")
    private int page;
    @SerializedName("total_movies")
    private int totalMovies;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("movies")
    private List<Movie> movies;



    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalMovies() {
        return totalMovies;
    }
    public void setTotalResults(int totalMovies) {
        this.totalMovies = totalMovies;
    }

    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Movie> getMovies(){
        return movies;
    }
    public void setMovies(List<Movie> movies) { this.movies = movies;}

    public List<Movie> getResults() {return movies;}
    public void setResults(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.page);
        dest.writeTypedList(this.movies);
        dest.writeInt(this.totalMovies);
        dest.writeInt(this.totalPages);
    }
    protected MoviesResponse(Parcel in) {
        page = in.readInt();
        totalMovies = in.readInt();
        totalPages = in.readInt();
        movies = in.createTypedArrayList(Movie.CREATOR);
    }

    public static final Creator<MoviesResponse> CREATOR = new Creator<MoviesResponse>() {
        @Override
        public MoviesResponse createFromParcel(Parcel in) {
            return new MoviesResponse(in);
        }

        @Override
        public MoviesResponse[] newArray(int size) {
            return new MoviesResponse[size];
        }
    };

}