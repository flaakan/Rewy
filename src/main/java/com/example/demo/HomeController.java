package com.example.demo;

import com.example.demo.Entites.Admin;
import com.example.demo.Entites.Genre;
import com.example.demo.Entites.Moviedetails;
import com.example.demo.Entites.Review;
import com.example.demo.Service.UserService;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.MovieService;
import com.example.demo.Entites.User;
import com.example.demo.Entites.ReviewVote;
import com.example.demo.Entites.Vote;
import com.example.demo.Service.GenreService;
import com.example.demo.Service.MovieService;
import com.example.demo.Service.ReviewService;
import com.example.demo.Service.ReviewVoteService;
import com.example.demo.Service.VoteService;
import com.example.demo.model.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.MoviedetailsService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HomeController {

    private final UserService userService;
    private final MovieService movieService;
    private final MoviedetailsService moviedetailsService;
    private final AdminService adminService;
    private final ReviewVoteService reviewVoteService;
    private final VoteService voteService;
    private final ReviewService reviewService;
    private final GenreService genreService;


    @Autowired
    public HomeController(UserService userService, MoviedetailsService moviedetailsService, AdminService adminService,
            ReviewVoteService reviewVoteService, ReviewService reviewService, VoteService voteService,GenreService genreService,MovieService movieService) {
        this.userService = userService;
        this.moviedetailsService = moviedetailsService;
        this.adminService = adminService;
        this.reviewVoteService = reviewVoteService;
        this.voteService = voteService;
        this.reviewService = reviewService;
        this.genreService = genreService;
        this.movieService = movieService;
    }
    
    @RequestMapping("/")
    public List<Movie> home() {

        return movieService.getAllMovies();
    }


    @RequestMapping("/admindelete")
    public String AdminDelete() {
        adminService.deleteAdmin(userService.findUserById(1));
        return "admin deleted";
    }

    @RequestMapping("/allvotes")
    public List<Vote> allvotes() {
        return voteService.getAllVotes();
    }

    @RequestMapping("/allreviews")
    public List<Review> allreviews() {
        System.out.println("hello from homecontroller");

        return reviewService.getAllReviews();
    }

    @RequestMapping("/addreviewvote")
    public String addreviewvote() {
        Review review = reviewService.findReviewById(2);

        Vote vote = voteService.findVoteById(3);
        
        ReviewVote rv = new ReviewVote();
        rv.setReview(review);
        rv.setVote(vote);
        reviewVoteService.addReviewVote(rv);

        return "added reviewvote";
    }

    @RequestMapping("/user")
    public Optional<User> getUser() {

        return userService.findUserById(1);
    }

    @RequestMapping("/allreviewvotes")
    public List<ReviewVote> allreviewVotes() {
        System.out.println(reviewVoteService.getAllReviewVotes());
        return reviewVoteService.getAllReviewVotes();
    }

    @RequestMapping("/registration")
    public String registration() {
        userService.registerUser(new User("Flakan", "Flakan123"));
        return "registered";
    }

    @PostMapping("/registration")
    ResponseEntity<User> postRegister(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    ResponseEntity<User> postLogin(@RequestBody User user) {
        System.out.println("user är skapad" + user.getUsername());
        return ResponseEntity.ok(userService.getLoginUser(user));
    }

    @RequestMapping("/exists")
    public boolean UserExists() {
        return userService.CheckUser("Flakanärbäst");
    }

    @RequestMapping("/getadmin")
    public Admin getadmin() {
        return adminService.getAdminByUserId(1);
    }


    @RequestMapping ("/movies")
    public List<Movie> movies(){
        return movieService.getAllMovies();
    }
    
        @RequestMapping ("/movie")
    public Moviedetails movie(){
        return moviedetailsService.findMovieById(1);
    }
}
