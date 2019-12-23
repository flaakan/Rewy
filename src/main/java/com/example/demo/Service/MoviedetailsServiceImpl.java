package com.example.demo.Service;

import com.example.demo.Entites.Moviedetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.MoviedetailsRepository;

@Service
public class MoviedetailsServiceImpl implements MoviedetailsService{
 
    private final MoviedetailsRepository movieRepository;
    
       @Autowired
    public MoviedetailsServiceImpl(final MoviedetailsRepository movieRepository) {
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
