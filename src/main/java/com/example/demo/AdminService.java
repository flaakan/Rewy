package com.example.demo;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AdminService {
    
    Admin getAdminByUserId(long userid);
    boolean checkIfAdmin(long userid);
    void createAdmin(User user);
    void deleteAdmin(User user);
}
