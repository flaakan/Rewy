package com.example.demo.Entites;

import javax.persistence.*;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private long id;

    @OneToOne
    @JoinColumn(name = "moviedetails_id", referencedColumnName = "id")
    private Moviedetails moviedetails;

    private String name;

    public Actor(){

    }

    public Actor(Moviedetails moviedetails, String actorName)
    {
        this.moviedetails = moviedetails;
        this.name = actorName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Moviedetails getMovie() {
        return moviedetails;
    }

    public void setMovie(Moviedetails movie) {
        this.moviedetails = movie;
    }
}
