package com.example.demo.Repository;

import com.example.demo.Entites.Actor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {

    @Query("from Actor where moviedetails_id = ?1")
    List<Actor> findActorById(long moviedetails_id);

}
