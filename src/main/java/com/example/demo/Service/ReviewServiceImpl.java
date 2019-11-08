package com.example.demo.Service;

import com.example.demo.Entites.Movie;
import com.example.demo.Entites.Review;
import com.example.demo.Entites.User;
import com.example.demo.Repository.ReviewRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviewsForMovie(Movie movie) {
        return reviewRepository.getAllReviewsByMovieId(movie.getId());
    }

    @Override
    public List<Review> getAllReviewsForUser(User user) {
        return reviewRepository.getAllReviewsByUserId(user.getId());
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public void addReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Review getreview2(long id) {
        return reviewRepository.getOne(id);
    }

}
