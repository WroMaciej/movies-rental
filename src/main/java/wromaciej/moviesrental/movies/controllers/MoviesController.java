package wromaciej.moviesrental.movies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wromaciej.moviesrental.movies.model.Actor;
import wromaciej.moviesrental.movies.model.Movie;
import wromaciej.moviesrental.movies.service.ActorService;
import wromaciej.moviesrental.movies.service.CartService;
import wromaciej.moviesrental.movies.service.MovieService;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value = "/movies")
public class MoviesController {

    private final MovieService movieService;
    private final CartService cartService;

    @Autowired
    public MoviesController(MovieService movieService, CartService cartService) {
        this.movieService = movieService;
        this.cartService = cartService;
    }

    @RequestMapping(value="/{movieId}")
    public @ResponseBody Movie findMovie(@PathVariable int movieId) {
        return movieService.findMovie(movieId);
    }

    @RequestMapping(value="/{movieId}/rental/{days}")
    public @ResponseBody double findMovieRentalRateForDays(@PathVariable int movieId, @PathVariable int days) {
        return cartService.calculateRentalRateForDays(movieId, days);
    }

    @RequestMapping(value="/{movieId}/actors")
    public @ResponseBody Collection<Actor> findMoviesWithActor(@PathVariable int movieId) {
        return movieService.findMovie(movieId).actors;
    }


    @RequestMapping(value="/title/{title}")
    public @ResponseBody
    List<Movie> findMovieByTitle(@PathVariable String title) {
        return movieService.findMoviesByTitle(title);
    }


    @RequestMapping(value="/")
    public @ResponseBody List<Movie> findAllMovies() {
        return movieService.findAllMovies();
    }

}
