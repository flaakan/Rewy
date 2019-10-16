package com.example.demo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserService {
    
    void deleteUser(long userid);
    void registerUser(User user);
    void updateUserName(long userid,String name);
    List<User> getAllUsers();
    
}
