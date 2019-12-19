package com.example.demo.Repository;
import com.example.demo.Entites.Moviedetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface MovieRepository extends JpaRepository<Moviedetails,Long> {
    
    @Query("from Moviedetails where id = ?1")
    Moviedetails findMovieById(long movieid);
}
