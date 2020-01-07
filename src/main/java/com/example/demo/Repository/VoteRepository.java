package com.example.demo.Repository;

import com.example.demo.Entites.Vote;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {
    
    // All votes for an User. Might be used for user history?
    @Query("from Vote where user_id = ?1")
    List<Vote> GetAllVotesForUser(long userid);
    
    @Query("from Vote where id = ?1")
    Vote findVoteById(long voteid);
    
    @Query("from Vote where votetype = ?1")
    Vote findVoteByVoteType(int votetype);
    
}

