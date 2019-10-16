package com.example.demo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserService {
    
    void createUser();
    void deleteUser(User user);
    void registerUser(User user);
    List<User> getAllUsers();
    
}
