package com.example.demo;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserService {
    
    User getOneUser(long userid);
    void deleteUser(long userid);
    void registerUser(User user);
    void updateUserName(long userid,String name);
    boolean CheckUser(String username);
    List<User> getAllUsers();
    
    
}
