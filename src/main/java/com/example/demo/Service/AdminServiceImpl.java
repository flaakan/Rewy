package com.example.demo.Service;

import com.example.demo.Repository.AdminRepository;
import com.example.demo.Entites.User;
import com.example.demo.Entites.Admin;
import com.example.demo.Repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    AdminRepository adminRepository;
    UserRepository userRepository;
    
    @Autowired
    public AdminServiceImpl(final AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Admin getAdminByUserId(long userid) {
        return adminRepository.getAdminByUserId(userid);

    }

    @Override
    public boolean checkIfAdmin(long userid) {
        return getAdminByUserId(userid)!=null;
    }

    @Override
    public void createAdmin(User user) {
        if(getAdminByUserId(user.getId()) == null){
            adminRepository.save(new Admin(user)); 
         }
        
    }

    @Override
    public void deleteAdmin(Optional <User> user) {
       Admin adminToDelete = getAdminByUserId(user.get().getId());
       if(adminToDelete != null){
        adminRepository.delete(adminToDelete);
        userRepository.delete(user.get());
       }
        
    }
}
