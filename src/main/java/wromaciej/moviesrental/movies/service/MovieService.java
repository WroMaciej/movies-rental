package wromaciej.moviesrental.movies.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wromaciej.moviesrental.movies.model.Movie;
import wromaciej.moviesrental.movies.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

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

    public List<Movie> findMoviesByTitle(String title) {
        return movieRepository.findByTitle(title);
    }


    public List<Movie> findAllMovies() {
        return Lists.newArrayList(movieRepository.findAll());
    }

}
