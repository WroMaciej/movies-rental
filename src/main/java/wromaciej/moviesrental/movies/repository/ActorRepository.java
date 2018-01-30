package wromaciej.moviesrental.movies.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wromaciej.moviesrental.movies.model.Actor;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {
    List<Actor> findByFirstName(String firstName);
    List<Actor> findByLastName(String lastName);
    List<Actor> findByFirstNameAndLastName(String firstName, String lastName);
}
