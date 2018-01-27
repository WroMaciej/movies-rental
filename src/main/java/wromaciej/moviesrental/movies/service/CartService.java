package wromaciej.moviesrental.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wromaciej.moviesrental.movies.model.Movie;
import wromaciej.moviesrental.movies.repository.MovieRepository;

import java.util.Collection;

@Service
public class CartService  {
    private final MovieRepository movieRepository;

    @Autowired
    public CartService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public double calculateRentalRate(Collection<Integer> movieIds) {
        double sum = 0;
        for(Integer movieId: movieIds) {
            Movie movie = movieRepository.findOne(movieId);
            sum += movie.getRentalRate();
        }

        return sum;
    }
}
