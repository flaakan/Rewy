package com.example.demo.Service;

import com.example.demo.Entites.Movie;
import com.example.demo.Repository.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{
 
    private final MovieRepository movieRepository;
    
       @Autowired
    public MovieServiceImpl(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    @Override
   public void addMovie(){
       movieRepository.save(new Movie("Kill Bill","About killing bill"));       
   }
    @Override
    public Movie findMovieById(long movieid){        
        return movieRepository.findMovieById(movieid);
    }
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    
}
