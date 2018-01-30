package wromaciej.moviesrental.movies.service;

import com.google.common.collect.Lists;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import wromaciej.moviesrental.movies.model.Movie;
import wromaciej.moviesrental.movies.repository.MovieRepository;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {

    private MovieService movieService = Mockito.mock(MovieService.class);
    private CartService cartService = new CartService(movieService);

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

        Mockito.when(movieService.findMovie(movie1.getId())).thenReturn(movie1);

        // WHEN
        double rentalRate = cartService.calculateRentalRate(movieIds);

        // THEN
        assertThat(rentalRate, equalTo(3.5));
    }

    @Test
    public void shouldReturn0ForNoRentalDays(){
        // GIVEN

        int rentalDays=0;
        Mockito.when(movieService.findMovie(movie1.getId())).thenReturn(movie1);

        // WHEN
        double rentalRateForDays = cartService.calculateRentalRateForDays(movie1.getId(),rentalDays);

        // THEN
        assertThat(rentalRateForDays, equalTo(0.0));
    }

    @Test
    public void shouldReturn7For2RentalDays(){
        // GIVEN

        int rentalDays=2;
        Mockito.when(movieService.findMovie(movie1.getId())).thenReturn(movie1);

        // WHEN
        double rentalRateForDays = cartService.calculateRentalRateForDays(movie1.getId(),rentalDays);

        // THEN
        assertThat(rentalRateForDays, equalTo(7.0));
    }

    @Rule public final ExpectedException exception = ExpectedException.none();
    @Test
    public void shouldThrowExceptionForNegativeRentalDays() throws  IllegalArgumentException{
        // GIVEN
        int rentalDays=-1;
        Mockito.when(movieService.findMovie(movie1.getId())).thenReturn(movie1);
        // WHEN
        exception.expect(IllegalArgumentException.class);
        //THEN
        cartService.calculateRentalRateForDays(movie1.getId(),rentalDays);
    }
    
    @Rule public final ExpectedException exception2 = ExpectedException.none();
    @Test
    public void shouldThrowExceptionForIllegalMovie() throws  NoSuchElementException{
        // GIVEN
        int movieId=-1;
        // WHEN
        exception.expect(NoSuchElementException.class);
        //THEN
        cartService.calculateRentalRateForDays(movieId,1);
    }




}
