package com.example.demo.Service;

import com.example.demo.Entites.User;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserService {
    
    User getOneUser(long userid);
    void deleteUser(long userid);
    void deleteUserByUsername(String username);
    User registerUser(User user);
    void updateUserName(long userid, String username);
    boolean CheckUser(String username);
    User getLoginUser(User user);
    List<User> getAllUsers();
    User getUserByUsername(String username);
    
    
}
