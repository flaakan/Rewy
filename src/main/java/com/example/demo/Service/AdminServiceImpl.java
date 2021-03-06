package com.example.demo.Service;

import com.example.demo.Repository.AdminRepository;
import com.example.demo.Entites.User;
import com.example.demo.Entites.Admin;
import com.example.demo.Repository.UserRepository;
import java.util.List;
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
        List<Admin> admins = adminRepository.findAll();
        for (Admin a : admins) {
            if (a.getUser().getId() == userid) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void createAdmin(User user) {
        List<Admin> allAdmins = adminRepository.findAll();
        int counter = 0;
        for(Admin a : allAdmins){
            if(a.getUser().getId() == user.getId()){
                counter++;
            }
        }
        if(counter ==0){
            adminRepository.save(new Admin(user));
        }
    }

    @Override
    public void deleteAdmin(User user) {
        Admin adminToDelete = getAdminByUserId(user.getId());
        adminRepository.delete(adminToDelete);
        userRepository.delete(user);
    }
}
