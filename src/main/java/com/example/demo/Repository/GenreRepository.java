package com.example.demo.Repository;

import com.example.demo.Entites.Admin;
import com.example.demo.Entites.Genre;
import com.example.demo.Entites.Moviedetails;
import com.example.demo.Entites.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {

       @Query("from Genre where moviedetails_id = ?1")
    List<Genre> findGenreById(long movieid);
}
