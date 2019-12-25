package com.example.demo.Service;


import com.example.demo.model.Movie;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MovieService {

    List<Movie> getAllMovies();
    
}

