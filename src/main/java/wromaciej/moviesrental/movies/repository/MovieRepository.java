package wromaciej.moviesrental.movies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wromaciej.moviesrental.movies.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
