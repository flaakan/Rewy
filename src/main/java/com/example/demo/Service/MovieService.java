package com.example.demo.Service;

import com.example.demo.Entites.Movie;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MovieService {
    
    void addMovie();
    Movie getMovie();
}
