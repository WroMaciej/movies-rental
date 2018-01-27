package wromaciej.moviesrental.movies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wromaciej.moviesrental.movies.model.Movie;
import wromaciej.moviesrental.movies.service.MovieService;

@Controller
@RequestMapping(value = "/movies")
public class MoviesController {

    private final MovieService movieService;

    @Autowired
    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value="/{movieId}")
    public @ResponseBody Movie findMovie(@PathVariable int movieId) {
        return movieService.findMovie(movieId);
    }

}
