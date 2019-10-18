package com.example.demo;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AdminService {
    
    boolean checkIfAdmin(long userid);
    void updateToAdmin(long userid);
    void deleteAdmin(long userid);
}
