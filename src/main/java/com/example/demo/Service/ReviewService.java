package com.example.demo.Service;

import com.example.demo.Entites.Movie;
import com.example.demo.Entites.Review;
import com.example.demo.Entites.User;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ReviewService {
    
    List<Review> getAllReviewsForMovie(Movie movie);
    List<Review> getAllReviewsForUser(User user);
}
