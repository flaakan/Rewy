package com.example.demo.Service;


import com.example.demo.Entites.Actor;
import com.example.demo.Entites.Moviedetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ActorService {

    List<Actor> getActorsForMovies(Moviedetails movie);

    void createActor(Actor actor);
}
