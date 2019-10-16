package com.example.demo;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MovieService {
    
    void addMovie();
    Movie getMovie();
}
