package com.example.demo.Repository;

import com.example.demo.Entites.Review;
import com.example.demo.Entites.ReviewVote;
import com.example.demo.Entites.Vote;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ReviewVoteRepository extends JpaRepository<ReviewVote, Long> {
    
    // Gets total Votes for a Review
    @Query("from ReviewVote where review_id = ?1 ")
    List<ReviewVote> getAllVotesForReview(long reviewId);
    
    // Upvotes
    @Query("from ReviewVote where review_id = ?1 and voteType = 1")
    List<ReviewVote> getAllUpvotesForReview(long reviewId);
    
    
    //Behöver på något sätt hitta alla reviewVotes för en User.
    

}

