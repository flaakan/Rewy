package com.example.demo.Service;

import com.example.demo.Entites.Vote;
import com.example.demo.Repository.VoteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;
    
           @Autowired
    public VoteServiceImpl(final VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }
    
    @Override
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    @Override
    public void addVote(Vote vote) {
        voteRepository.save(vote);
    }

    @Override
    public Vote findVoteById(long voteid) {
        return voteRepository.findVoteById(voteid);
    }

    
}
