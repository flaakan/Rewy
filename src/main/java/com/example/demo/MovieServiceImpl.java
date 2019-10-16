package com.example.demo;

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
    public Movie getMovie(){        
        return movieRepository.findAll().get(0);
    }
    
}
