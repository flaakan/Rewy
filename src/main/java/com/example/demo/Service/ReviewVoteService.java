package com.example.demo.Service;

import com.example.demo.Entites.ReviewVote;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ReviewVoteService {
    
    List<ReviewVote> getAllVotesForReview(long reviewId);
    List<ReviewVote> getAllUpVotesForReview(long reviewId);
    List<ReviewVote> getAllReviewVotes();

    public void addReviewVote(ReviewVote rv);
}
