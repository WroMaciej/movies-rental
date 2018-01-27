package wromaciej.moviesrental.movies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wromaciej.moviesrental.movies.model.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
    List<Movie> findByTitle(String title);
}
