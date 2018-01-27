package wromaciej.moviesrental.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wromaciej.moviesrental.movies.model.Movie;
import wromaciej.moviesrental.movies.repository.MovieRepository;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie findMovie(int movieId) {
        return movieRepository.findOne(movieId);
    }

}
