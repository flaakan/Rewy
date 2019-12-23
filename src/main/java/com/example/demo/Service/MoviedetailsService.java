package com.example.demo.Service;

import com.example.demo.Entites.Moviedetails;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MoviedetailsService {
    
    void addMovie();
    Moviedetails findMovieById(long movieid);
    List<Moviedetails> getAllMovies();
}
