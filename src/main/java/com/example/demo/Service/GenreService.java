package com.example.demo.Service;

import com.example.demo.Entites.Admin;
import com.example.demo.Entites.Genre;
import com.example.demo.Entites.Moviedetails;
import com.example.demo.Entites.User;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GenreService {
    

    List<Genre> getGenresForMovie(Moviedetails movie);
    
    void createGenre(Genre genre);
}
