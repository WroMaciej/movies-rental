package wromaciej.moviesrental.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wromaciej.moviesrental.movies.model.Movie;
import wromaciej.moviesrental.movies.repository.MovieRepository;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class CartService {
    private final MovieService movieService;

    @Autowired
    public CartService(MovieService movieService) {
        this.movieService = movieService;
    }

    public Movie findMovie(int movieId) {
        Movie movie = movieService.findMovie(movieId);
        if (movie != null) {
            return movie;
        } else {
            throw new NoSuchElementException("Movie with ID " + movieId + " not found.");
        }

    }

    public double calculateRentalRate(Collection<Integer> movieIds) {
        double sum = 0;
        for (Integer movieId : movieIds) {
            Movie movie = findMovie(movieId);
            sum += movie.getRentalRate();
        }
        return sum;
    }

    public double calculateRentalRateForDays(int movieId, int rentalDays) {
        if (rentalDays >= 0) {
            Movie movie = findMovie(movieId);
            return movie.getRentalRate() * rentalDays;
        } else
            throw new IllegalArgumentException("Rental duration is a negative number! Rental duration must be a positive number.");

    }


}
