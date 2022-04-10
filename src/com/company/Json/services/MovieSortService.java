package com.company.Json.services;

import com.company.Json.enums.SortType;
import com.company.Json.models.Movie;
import com.company.Json.repositories.MovieRepository;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;

public class MovieSortService {

    private final MovieRepository movieRepository;

    public MovieSortService() throws FileNotFoundException {
        this.movieRepository = new MovieRepository();
    }

    public List<Movie> sortMoviesByName(SortType sortType){
        if (sortType.equals(SortType.ASC)) {
            return movieRepository.getMovieList().stream()
                    .sorted(Comparator.comparing(Movie::getName))
                    .toList();
        } else {
            return movieRepository.getMovieList().stream()
                    .sorted(Comparator.comparing(Movie::getName).reversed())
                    .toList();
        }
    }
}
