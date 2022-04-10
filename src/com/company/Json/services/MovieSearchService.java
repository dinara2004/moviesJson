package com.company.Json.services;

import com.company.Json.models.Movie;
import com.company.Json.repositories.MovieRepository;

import java.io.FileNotFoundException;

public class MovieSearchService {

    private final MovieRepository movieRepository;

    public MovieSearchService() throws FileNotFoundException {
        movieRepository = new MovieRepository();
    }

    public Movie findMovieByName(String movieName){
       return movieRepository.getMovieList().stream()
                .filter(m -> m.getName().equals(movieName))
                .findFirst().orElseThrow(() -> new RuntimeException("Movie not found!!!"));
    }
}
