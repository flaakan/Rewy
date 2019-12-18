package com.example.demo.Service;

import com.example.demo.Entites.Moviedetails;
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
       movieRepository.save(new Moviedetails("Kill Bill","About killing bill"));       
   }
    @Override
    public Moviedetails findMovieById(long movieid){        
        return movieRepository.findMovieById(movieid);
    }
    public List<Moviedetails> getAllMovies(){
        return movieRepository.findAll();
    }
    
}
