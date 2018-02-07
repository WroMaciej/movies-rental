package wromaciej.moviesrental.movies.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wromaciej.moviesrental.movies.model.Actor;
import wromaciej.moviesrental.movies.repository.ActorRepository;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor findActor(int actorId) {
        return actorRepository.findOne(actorId);
    }

    public List<Actor> findActorByFirstName(String firstName) {
        return actorRepository.findByFirstName(firstName);
    }

    public List<Actor> findActorByLastName(String lastName) {
        return actorRepository.findByLastName(lastName);
    }

    public List<Actor> findActorByFullName(String firstName, String lastName) {
        return actorRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Actor> findAllActors(){
        return Lists.newArrayList(actorRepository.findAll());
    }

    public List<Actor> findActorsWithLastName(String lastName) {
        return actorRepository.findByLastName(lastName);
    }
}
