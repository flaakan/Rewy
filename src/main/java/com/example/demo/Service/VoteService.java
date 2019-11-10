
package com.example.demo.Service;

import com.example.demo.Entites.Vote;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface VoteService {
    
    List<Vote> getAllVotes();
    void addVote(Vote vote);
    Vote findVoteById(long voteid);
    Vote findVoteByVoteType(int votetype);
}
