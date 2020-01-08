package com.example.demo.Service;

import com.example.demo.Entites.Actor;
import com.example.demo.Entites.Genre;
import com.example.demo.Entites.Moviedetails;
import com.example.demo.Repository.ActorRepository;
import com.example.demo.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.MoviedetailsRepository;
import com.example.demo.model.Movie;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MoviedetailsRepository moviedetailsRepository;
    private final GenreRepository genreRepository;
    private final GenreService genreService;
    private final ActorRepository actorRepository;
    private final ActorService actorService;

    @Autowired
    public MovieServiceImpl(MoviedetailsRepository moviedetailsRepository, GenreRepository genreRepository, GenreService genreService, ActorRepository actorRepository, ActorService actorService) {
        this.moviedetailsRepository = moviedetailsRepository;
        this.genreRepository = genreRepository;
        this.genreService = genreService;
        this.actorRepository = actorRepository;
        this.actorService = actorService;
    }

    @Override
    public List<Movie> getAllMovies() {

        List<Movie> moviesAndGenreList = new ArrayList<>();
        //List <Genre> allGenres = genreRepository.findAll();
        List<Moviedetails> allMoviedetails = moviedetailsRepository.findAll();

        for (Moviedetails md : allMoviedetails) {
            Movie movie = new Movie(md);
            List<String> genreStringList = new ArrayList<>();

            for (Genre g : genreService.getGenresForMovie(md)) {

                genreStringList.add(g.getName());
            }

            movie.setGenreList(genreStringList);
            moviesAndGenreList.add(movie);

        }

        return moviesAndGenreList;

    }

    @Override
    public List<Movie> getMoviesWithActors() {
        List<Movie> moviesAndActorList = new ArrayList<>();
        //List <Actor> allActors = actorRepository.findAll();
        List<Moviedetails> allMoviedetails = moviedetailsRepository.findAll();

        for (Moviedetails md : allMoviedetails) {
            Movie movie = new Movie(md);
            List<String> actorStringList = new ArrayList<>();

            for (Actor a : actorService.getActorsForMovies(md)) {

                actorStringList.add(a.getName());
            }
            movie.setActorList(actorStringList);
            moviesAndActorList.add(movie);

        }
        return moviesAndActorList;
    }

    @Override
    public Movie getOneMovie(long id) {
        Moviedetails mvd = moviedetailsRepository.findMovieById(id);
        Movie movie = new Movie(mvd);

        List<String> genreStringList = new ArrayList<>();
        
        for (Genre g : genreService.getGenresForMovie(mvd)) {
            genreStringList.add(g.getName());
        }
        movie.setGenreList(genreStringList);
        
        
        List<String> actorStringList = new ArrayList<>();

        for (Actor a : actorService.getActorsForMovies(mvd)) {
           actorStringList.add(a.getName());
        }
        movie.setActorList(actorStringList);
        
        return movie;
    }

}
