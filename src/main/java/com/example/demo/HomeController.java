package com.example.demo;

import com.example.demo.Entites.Admin;
import com.example.demo.Entites.Review;
import com.example.demo.Service.*;
import com.example.demo.Entites.User;
import com.example.demo.Entites.ReviewVote;
import com.example.demo.Entites.Vote;
import com.example.demo.Service.MovieService;
import com.example.demo.model.Movie;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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


    @RequestMapping("/login/{username}/{password}")
    public String loginPage(@PathVariable(value = "username")String username, @PathVariable(value = "password") String password)
    {
        String outPut = "";

        if(userService.CheckUser(username) && userService.findUserByUsername(username).getPassword().equals(password))
        {
            outPut = "The user: " + username + " exits on the database. ";
            if(adminService.checkIfAdmin(userService.findUserByUsername(username).getId()))
            {
                outPut = outPut + ". The user is admin.";
            }
            else
            {
                outPut = outPut + ". The user is member.";
            }
        }
        else {
            outPut = "The user: " + username + " doesn't exits on the database";
        }

        return outPut;
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

   /* @RequestMapping("/registration")
    public String registration() {
        userService.registerUser(new User("Flakan", "Flakan123"));
        return "registered";
    }*/

    @RequestMapping("/registration/{username}/{password}")
    public String registration(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password){
        Crypto encPassword = new PasswordCrypto();

        String enc = new String(encPassword.encrypt(password.getBytes()));
        System.out.println(enc);
        String dec = new String(encPassword.decrypt(enc.getBytes()));
        System.out.println(dec);

        userService.registerUser(new User(username,enc));
        return "registered : \nUser : " + username + "\npass " + enc + "\n (Decoded password : " + dec;
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


    @RequestMapping("/movies")
    public List<Movie> movie() {
        return movieService.getMoviesWithActors();
    }
}

