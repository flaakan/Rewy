package com.example.demo.Service;

import com.example.demo.Entites.User;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserService {
    
    User getOneUser(long userid);
    void deleteUser(long userid);
    User registerUser(User user);
    void updateUserName(long userid,String name);
    boolean CheckUser(String username);
    User getLoginUser(User user);
    List<User> getAllUsers();
    
    
}
