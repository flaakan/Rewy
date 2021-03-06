package com.example.demo.Service;

import com.example.demo.Entites.User;
import com.example.demo.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    User user;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    public void setUser(User user){
        this.user = user;
    }
    
    public User getUser(){
        return user;
    }

    /**
     *
     * @param userid
     * Fetches an User by the userid.
     * @return User
     */
    @Override
    public User getOneUser(long userid) {
        return userRepository.getOne(userid);
    }

    /**
     *
     * @param user
     * Uses the method CheckUser and if the user
     * is not in the database, adds the user.
     * @return
     */
    @Override
    public User registerUser(User user) {
        if (!(CheckUser(user.getUsername()))) {
            userRepository.save(user);
        }
        return user;

    }

    /**
     *
     * @param userid
     * Deletes a user by their user id.
     */
    @Override
    public void deleteUser(long userid) {
        User userToDelete = userRepository.getOne(userid);
        userRepository.delete(userToDelete);

    }

    /**
     *
     * @param userid
     * @param name
     * 
     * Updates the username with param name, on the user with param userid.
     */
    @Override
    public void updateUserName(long userid, String name) {
        User userToUpdate = userRepository.getOne(userid);
        userToUpdate.setUsername(name);
        userRepository.save(userToUpdate);
    }

    /**
     *
     * @param username
     * Checks if the username exists in the database.
     * @return boolean
     */
    @Override
    public boolean CheckUser(String username) {
        User user = userRepository.findUserByUsername(username);
        return user != null;
    }

    /**
     *
     * @param user
     * Gets an User and checks if the username and password matches,
     * if it does returns this User.
     * @return User
     */
    @Override
    public User getLoginUser(User user) {
        List<User> users = getAllUsers();
        for(User u : users){
            if(u.getUsername().equalsIgnoreCase(user.getUsername())&& u.getPassword().equals(user.getPassword())){
                setUser(user);
                return user;
            }        
        }
        return new User();
    }

    /**
     * Fetches all existing users in the database.
     * @return List<User>
     */
    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    
    
}
