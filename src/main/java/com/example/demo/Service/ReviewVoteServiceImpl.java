package com.example.demo.Service;

import com.example.demo.Entites.ReviewVote;
import com.example.demo.Repository.ReviewVoteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewVoteServiceImpl implements ReviewVoteService{
    
        private final ReviewVoteRepository reviewVoteRepository;
    
       @Autowired
    public ReviewVoteServiceImpl(final ReviewVoteRepository reviewVoteRepository) {
        this.reviewVoteRepository = reviewVoteRepository;
    }

    @Override
    public List<ReviewVote> getAllVotesForReview(long reviewId) {
        return reviewVoteRepository.getAllVotesForReview(reviewId);
    }

    @Override
    public List<ReviewVote> getAllUpVotesForReview(long reviewId) {
        return reviewVoteRepository.getAllUpvotesForReview(reviewId);
    }

    @Override
    public List<ReviewVote> getAllReviewVotes(){
        return reviewVoteRepository.findAll();
    }
    
    @Override
    public void addReviewVote(ReviewVote rv) {
        reviewVoteRepository.save(rv);
    }

}
