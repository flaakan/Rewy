package com.example.demo.Repository;

import com.example.demo.Entites.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface VoteRepository extends JpaRepository<Vote,Long> {
    
}
