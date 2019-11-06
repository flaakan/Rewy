package com.example.demo.Service;

import com.example.demo.Entites.Movie;
import com.example.demo.Entites.Review;
import com.example.demo.Repository.ReviewRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    
    public ReviewServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviewsForMovie(Movie movie) {
        List<Review> allReviews = reviewRepository.findAll();
        List<Review> returnList = new ArrayList<>();
        for(Review r : allReviews){
            if(r.getMovie().equals(movie)){
                returnList.add(r);
            }
        }
        return returnList;
    }
    
}
