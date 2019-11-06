package com.example.demo.Repository;

import com.example.demo.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long>{
    
    @Query("from User where username = ?1 ")
    User findUserByUsername(String username);

}
