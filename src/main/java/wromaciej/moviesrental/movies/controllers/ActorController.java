package wromaciej.moviesrental.movies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wromaciej.moviesrental.movies.model.Actor;
import wromaciej.moviesrental.movies.service.ActorService;

@Controller
@RequestMapping(value="/actor")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @RequestMapping(value="/{actorId}")
    public @ResponseBody Actor findActor(@PathVariable int actorId){
        return actorService.findActor(actorId);
    }


}
