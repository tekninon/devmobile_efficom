package com.example.devmobile_efficom.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoviesResponse implements Serializable
{

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_movies")
    @Expose
    private Integer totalMovies;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("movies")
    @Expose
    private List<Movie> movies = null;
    private final static long serialVersionUID = 1234371452767924930L;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalMovies() {
        return totalMovies;
    }

    public void setTotalResults(Integer totalMovies) {
        this.totalMovies = totalMovies;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Movie> getMovies(){
        return movies;
    }

    public void setResults(List<Movie> movies) {
        this.movies = movies;
    }

}