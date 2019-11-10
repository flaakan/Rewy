package com.example.demo;

import com.example.demo.Entites.Admin;
import com.example.demo.Entites.Movie;
import com.example.demo.Entites.Review;
import com.example.demo.Service.UserService;
import com.example.demo.Service.AdminService;
import com.example.demo.Service.MovieService;
import com.example.demo.Entites.User;
import com.example.demo.Entites.ReviewVote;
import com.example.demo.Entites.Vote;
import com.example.demo.Service.ReviewService;
import com.example.demo.Service.ReviewVoteService;
import com.example.demo.Service.VoteService;
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
    private final ReviewVoteService reviewVoteService;
    private final VoteService voteService;
    private final ReviewService reviewService;

    @Autowired
    public HomeController(UserService userService, MovieService movieService, AdminService adminService,
            ReviewVoteService reviewVoteService, ReviewService reviewService, VoteService voteService) {
        this.userService = userService;
        this.movieService = movieService;
        this.adminService = adminService;
        this.reviewVoteService = reviewVoteService;
        this.voteService = voteService;
        this.reviewService = reviewService;
    }

    @RequestMapping("/")
    public String home() {
        userService.registerUser(new User("Faker", "Fakerfaker"));
        userService.registerUser(new User("1", "123123123"));
        userService.registerUser(new User("Dsadad", "123123123"));
        userService.updateUserName(3, "SaikatTheFeeder");
        movieService.addMovie();
        adminService.createAdmin(userService.findUserById(3));
        if (adminService.checkIfAdmin(userService.findUserById(1).getId())) {
            return "User is admin";
        } else {
            return "welcome to Rewy";
        }

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
        System.out.println(review.toString());
        Vote vote = voteService.findVoteById(3);
        System.out.println(vote.toString());
        ReviewVote rv = new ReviewVote();
        rv.setReview(review);
        rv.setVote(vote);
        reviewVoteService.addReviewVote(rv);

        return "added reviewvote";
    }

    @RequestMapping("/User")
    public User getUser() {
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

    @RequestMapping("/movie")
    public Movie movie() {
        return movieService.findMovieById(1);
    }
}
