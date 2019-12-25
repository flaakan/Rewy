package com.example.demo.Repository;

import com.example.demo.Entites.Admin;
import com.example.demo.Entites.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    @Query("from Admin where user_id = ?1")
    Admin getAdminByUserId(long userid);
    
}
