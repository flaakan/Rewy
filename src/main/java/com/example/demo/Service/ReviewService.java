package com.example.demo.Service;

import com.example.demo.Entites.Movie;
import com.example.demo.Entites.Review;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ReviewService {
    
    List<Review> getAllReviewsForMovie(Movie movie);
}
