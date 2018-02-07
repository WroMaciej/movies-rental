package wromaciej.moviesrental.movies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wromaciej.moviesrental.movies.model.Actor;
import wromaciej.moviesrental.movies.model.Movie;
import wromaciej.moviesrental.movies.service.ActorService;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value = "/actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @RequestMapping(value = "/")
    public @ResponseBody
    List<Actor> findAllActors() {
        return actorService.findAllActors();
    }

    @RequestMapping(value = "/{actorId}")
    public @ResponseBody
    Actor findActor(@PathVariable int actorId) {
        return actorService.findActor(actorId);
    }

    @RequestMapping(value = "/{actorId}/movies")
    public @ResponseBody
    Collection<Movie> findMoviesWithActor(@PathVariable int actorId) {
        return actorService.findActor(actorId).getMovies();
    }

    @RequestMapping(value = "/last_name/{lastName}")
    public @ResponseBody
    List<Actor> findActorsWithLastName(@PathVariable String lastName){
        return actorService.findActorByLastName(lastName);
    };



}
