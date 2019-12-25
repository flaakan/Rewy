package com.example.demo.Repository;
import com.example.demo.Entites.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    
    @Query("from Movie where id = ?1")
    Movie findMovieById(long movieid);
}