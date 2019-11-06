package com.example.demo.Repository;
import com.example.demo.Entites.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Johnn
 */
@Transactional
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    
}
