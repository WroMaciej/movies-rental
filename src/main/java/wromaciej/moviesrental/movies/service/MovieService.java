package wromaciej.moviesrental.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wromaciej.moviesrental.movies.dao.MovieDao;
import wromaciej.moviesrental.movies.model.Movie;

@Service
public class MovieService {

    private final MovieDao movieDao;

    @Autowired
    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public Movie findMovie(int movieId) {
        return movieDao.findMovie(movieId);
    }

}
