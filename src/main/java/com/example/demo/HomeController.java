package com.example.demo;

import com.example.demo.Entites.Admin;
import com.example.demo.Service.UserService;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.MovieService;
import com.example.demo.Entites.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HomeController {
    private final UserService userService;
    private final MovieService movieService;
    private final AdminService adminService;
    
    @Autowired
    public HomeController(UserService userService,MovieService movieService,AdminService adminService){
        this.userService = userService;
        this.movieService = movieService;
        this.adminService = adminService;
    }
    
    @RequestMapping("/")
    public String home(){
        userService.registerUser(new User("Faker","Fakerfaker"));
        userService.registerUser(new User("1","123123123"));
        userService.registerUser(new User("Dsadad","123123123"));
        userService.updateUserName(3,"SaikatTheFeeder");
        movieService.addMovie();
        adminService.createAdmin(userService.getOneUser(3));
       if(adminService.checkIfAdmin(userService.getOneUser(1).getId()))
            return "User is admin";
       else
            return "welcome to Rewy";
        
    }
    @RequestMapping("/user")
    public User getUser(){
        return userService.getUserByUsername("Flakan");
    }
    
    @RequestMapping("/admindelete")
    public String AdminDelete(){
        adminService.deleteAdmin(userService.getOneUser(1));
        return "admin deleted";
    }
    
    @RequestMapping("/registration")
    public String registration(){
        userService.registerUser(new User("Flakan","Flakan123"));
        return "registered";
    }
    
    @PostMapping("/registration")
    ResponseEntity<User> postRegister(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }
    
    @PostMapping("/login")
    ResponseEntity<User> postLogin(@RequestBody User user){
        return ResponseEntity.ok(userService.getLoginUser(user));
    }
    
    @RequestMapping("/exists")
    public boolean UserExists(){
        return userService.CheckUser("Flakanärbäst");
    }
    
    @RequestMapping("/getadmin")
    public Admin getadmin(){
        return adminService.getAdminByUserId(1);
    }
    
}
