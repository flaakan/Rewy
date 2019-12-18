/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Repository;

import com.example.demo.Entites.Moviedetails;
import com.example.demo.Entites.Review;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // Gets all reviews for an User
    @Query("from Review where user_id = ?1")
    List<Review> getAllReviewsByUserId(long userid);

    // Gets all reviews for a Movie
    @Query("from Review where movie_id = ?1")
    List<Review> getAllReviewsByMovieId(long movieid);
    
    @Query("from Review where id = ?1")
    Review findReviewById(long reviewid);


}
