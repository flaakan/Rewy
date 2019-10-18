package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    
    AdminRepository  adminRepository;
    
    @Autowired
    public AdminServiceImpl(final AdminRepository  adminRepository) {
        this.adminRepository = adminRepository;
    }    
    public boolean checkIfAdmin(long userid) {
        List<Admin> admins = adminRepository.findAll();
        for(Admin a: admins){
            if(a.getUserId() == userid){
                return true;
            }
            
        }
        return false;
    }

    @Override
    public void updateToAdmin(long userid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAdmin(long userid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
