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
    
    @Autowired
    public HomeController(UserService userService,MovieService movieService){
        this.userService = userService;
        this.movieService = movieService;
    }
    
    @RequestMapping("/")
    public Movie home(){
        userService.createUser();
        movieService.addMovie();
        return movieService.getMovie();
      //  return "welcome to Rewy";
        
    }
    
}
