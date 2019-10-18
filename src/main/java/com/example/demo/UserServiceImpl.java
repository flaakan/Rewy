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
    public User getOneUser(long userid) {
        return userRepository.getOne(userid);
    }

    @Override
    public void registerUser(User user) {
        if (!(CheckUser(user.getUsername()))) {
            userRepository.save(user);
        }

    }

    @Override
    public void deleteUser(long userid) {
        User userToDelete = userRepository.getOne(userid);
        userRepository.delete(userToDelete);

    }

    public void updateUserName(long userid, String name) {
        User userToUpdate = userRepository.getOne(userid);
        userToUpdate.setUsername(name);
        userRepository.save(userToUpdate);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public boolean CheckUser(String username) {
        List<User> allUsers = userRepository.findAll();
        for (User u : allUsers) {
            if (username.equalsIgnoreCase(u.getUsername())) {
                return true;
            }
        }
        return false;
    }

}
