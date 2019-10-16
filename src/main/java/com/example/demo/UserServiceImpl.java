package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Johnn
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
     @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public void createUser() {
        userRepository.save(new User("Flakan","lösenord"));
    }

    @Override
    public void deleteUser(User user){
        userRepository.delete(user);

    }

    @Override
    public void registerUser(User user) {
        List<User> allUsers = getAllUsers();
        
        for(User u : allUsers){
            if(!user.getUsername().equalsIgnoreCase(u.getUsername())){
                userRepository.save(user);
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();    
    }

    
    
    
}
