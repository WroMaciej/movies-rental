package wromaciej.moviesrental.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wromaciej.moviesrental.movies.model.Movie;
import wromaciej.moviesrental.movies.repository.MovieRepository;

import java.util.Collection;

@Service
public class CartService  {
    private final MovieRepository movieRepository;
    private final MovieService movieService;

    @Autowired
    public CartService(MovieRepository movieRepository, MovieService movieService) {
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }

    public double calculateRentalRate(Collection<Integer> movieIds) {
        double sum = 0;
        for(Integer movieId: movieIds) {
            Movie movie = movieRepository.findOne(movieId);
            sum += movie.getRentalRate();
        }
        return sum;
    }

    public double calculateRentalRateForDays(int movieId, int rentalDays){
        if (rentalDays>=0){
            return movieService.findMovie(movieId).getRentalRate()*rentalDays;
        } else throw new IllegalArgumentException("Rental duration is a negative number! Rental duration must be a positive number.");

    }


}
