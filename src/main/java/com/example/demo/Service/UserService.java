package com.example.demo.Service;

import com.example.demo.Entites.User;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserService {
    
    Optional <User> findUserById(long userid);
    void deleteUser(long userid);
    void deleteUserByUsername(String username);
    User registerUser(User user);
    void updateUserName(long userid, String username);
    boolean CheckUser(String username);
    User getLoginUser(User user);
    List<User> getAllUsers();
    User findUserByUsername(String username);
    
    
}
