package com.example.demo.Service;

import com.example.demo.Entites.Actor;
import com.example.demo.Entites.Moviedetails;
import com.example.demo.Repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository)
    {
        this.actorRepository = actorRepository;
    }


    @Override
    public List<Actor> getActorsForMovies(Moviedetails movie) {
        return actorRepository.findActorById(movie.getId());
    }

    @Override
    public void createActor(Actor actor) {
        actorRepository.save(actor);
    }
}
