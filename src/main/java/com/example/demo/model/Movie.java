/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import com.example.demo.Entites.Genre;
import com.example.demo.Entites.Moviedetails;
import java.util.List;

/**
 *
 * @author Kenny Hoang
 */
public class Movie {
    
    Moviedetails movie;
    List <String> GenreList;
    List <String> ActorList;

    public Movie() {
    }
    
    public Movie(Moviedetails movie) {
        this.movie = movie;
    }

    public Moviedetails getMovie() {
        return movie;
    }

    public void setMovie(Moviedetails movie) {
        this.movie = movie;
    }

    public List<String> getGenreList() {
        return GenreList;
    }

    public void setGenreList(List<String> GenreList) {
        this.GenreList = GenreList;
    }

    public List<String> getActorList() {
        return ActorList;
    }

    public void setActorList(List<String> actorList) {
        ActorList = actorList;
    }
}
