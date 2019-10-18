package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Kenny Hoang
 */
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
        userService.deleteUser(2);
        userService.registerUser(new User("1","123123123"));
        userService.registerUser(new User("Dsadad","123123123"));
        userService.updateUserName(3,"SaikatTheFeeder");
        movieService.addMovie();
       // return movieService.getMovie();
       if(adminService.checkIfAdmin(userService.getOneUser(1).getId()))
            return "User is admin";
       else
            return "welcome to Rewy";
        
    }
    
}
