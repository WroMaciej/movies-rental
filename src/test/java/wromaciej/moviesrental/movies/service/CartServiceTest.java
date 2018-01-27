package wromaciej.moviesrental.movies.service;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import wromaciej.moviesrental.movies.model.Movie;
import wromaciej.moviesrental.movies.repository.MovieRepository;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {

    private MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
    private CartService cartService = new CartService(movieRepository);

    private Movie movie1 = new Movie(1, "Godfatther 1", 3.5);

    @Test
    public void shouldReturn0ForEmptyMovieList(){
        // GIVEN
        ArrayList<Integer> movieIds = new ArrayList<>();

        // WHEN
        double rentalRate = cartService.calculateRentalRate(movieIds);

        // THEN
        assertThat(rentalRate, equalTo(0.0));
    }

    @Test
    public void shouldReturn3p5ForMovie1(){
        // GIVEN
        ArrayList<Integer> movieIds = Lists.newArrayList(movie1.getId());

        Mockito.when(movieRepository.findOne(movie1.getId())).thenReturn(movie1);

        // WHEN
        double rentalRate = cartService.calculateRentalRate(movieIds);

        // THEN
        assertThat(rentalRate, equalTo(3.5));
    }



}
