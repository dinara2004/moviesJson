package com.company.Json;

import com.company.Json.enums.SortType;
import com.company.Json.models.Movie;
import com.company.Json.services.MovieSearchService;
import com.company.Json.services.MovieSortService;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        MovieSearchService movieSearchService = new MovieSearchService();
        MovieSortService movieSortService = new MovieSortService();
        Scanner scanner = new Scanner(System.in);
        System.out.print("How you want to sort ASC or DESC: ");
        String sort = scanner.nextLine();
        List<Movie> movies;
        if (sort.equalsIgnoreCase("asc")){
            movies = movieSortService.sortMoviesByName(SortType.ASC);
        } else if (sort.equalsIgnoreCase("desc")){
            movies = movieSortService.sortMoviesByName(SortType.DESC);
        } else {
            throw new RuntimeException("You write wrong type!!!!!!");
        }

        movies.stream().forEach(System.out::println);

        try {
            System.out.print("Напишите название фильма, которую хотите найти: ");
            String movieName = scanner.nextLine();
            Movie movie = movieSearchService.findMovieByName(movieName);
            System.out.println(movie);
        } catch (RuntimeException r) {
            System.out.println(r.getMessage());
        }

    }
}
