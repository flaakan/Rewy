package com.example.demo.Service;

import com.example.demo.Entites.Admin;
import com.example.demo.Entites.User;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AdminService {
    
    Admin getAdminByUserId(long userid);
    boolean checkIfAdmin(long userid);
    void createAdmin(User user);
    void deleteAdmin(User user);
}
