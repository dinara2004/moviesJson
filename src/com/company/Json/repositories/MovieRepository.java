package com.company.Json.repositories;

import com.company.Json.models.Movie;
import com.company.Json.models.Movies;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieRepository {
    private final List<Movie> movieList;

    public MovieRepository() throws FileNotFoundException {
        Gson gson = new Gson();

        JsonReader jsonReader = new JsonReader(
                new FileReader("resources/movies.json")
        );

        Movies movies = gson.fromJson(jsonReader, Movies.class);

        movieList = movies.getMovies();
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
}
