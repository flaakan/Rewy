package com.example.demo.Service;

import com.example.demo.Repository.AdminRepository;
import com.example.demo.Entites.User;
import com.example.demo.Entites.Admin;
import com.example.demo.Entites.Genre;
import com.example.demo.Entites.Moviedetails;
import com.example.demo.Repository.GenreRepository;
import com.example.demo.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    GenreRepository genreRepository;
    
    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    @Override
    public void createGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public List<Genre> getGenresForMovie(Moviedetails movie) {
        return genreRepository.findGenreById(movie.getId());
    }

}
