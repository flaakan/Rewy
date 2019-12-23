package com.example.demo.Service;

import com.example.demo.Entites.Genre;
import com.example.demo.Entites.Moviedetails;
import com.example.demo.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.MoviedetailsRepository;
import com.example.demo.model.Movie;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
 
    private final MoviedetailsRepository moviedetailsRepository;
    private final GenreRepository genreRepository;
    private final GenreService genreService;
    
    
    @Autowired
    
    public MovieServiceImpl(MoviedetailsRepository moviedetailsRepository, GenreRepository genreRepository, GenreService genreService) {
    this.moviedetailsRepository = moviedetailsRepository;
    this.genreRepository = genreRepository;
    this.genreService = genreService;
    }

    @Override
    public List<Movie> getAllMovies() {
        
        List<Movie> moviesAndGenreList = new ArrayList<>();
        
        List <Genre> allGenres = genreRepository.findAll();
        List <Moviedetails> allMoviedetails = moviedetailsRepository.findAll();
        
        
        for(Moviedetails md: allMoviedetails){
            Movie movie = new Movie(md);
            List<String> genreStringList =  new ArrayList<>();
            
            for(Genre g: genreService.getGenresForMovie(md)){
               
                genreStringList.add(g.getName());
            }
            
            movie.setGenreList(genreStringList);
            moviesAndGenreList.add(movie);

        }   

          
    return moviesAndGenreList;
    }
    
    
}